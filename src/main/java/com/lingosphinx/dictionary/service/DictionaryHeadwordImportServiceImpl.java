package com.lingosphinx.dictionary.service;

import com.lingosphinx.dictionary.domain.*;
import com.lingosphinx.dictionary.dto.DictionaryHeadwordImportDto;
import com.lingosphinx.dictionary.exception.ResourceNotFoundException;
import com.lingosphinx.dictionary.mapper.DictionaryHeadwordImportMapper;
import com.lingosphinx.dictionary.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class DictionaryHeadwordImportServiceImpl implements DictionaryHeadwordImportService {

    private final DictionaryRepository dictionaryRepository;
    private final DictionaryHeadwordRepository dictionaryHeadwordRepository;
    private final DictionaryEntryRepository dictionaryEntryRepository;
    private final LexemeRepository lexemeRepository;
    private final WordRepository wordRepository;
    private final PartOfSpeechRepository partOfSpeechRepository;
    private final WordFormRepository wordFormRepository;
    private final FormRepository formRepository;
    private final DictionaryHeadwordImportMapper dictionaryHeadwordImportMapper;

    @Override
    public DictionaryHeadwordImportDto create(DictionaryHeadwordImportDto dictionaryHeadwordImportDto) {
        var dictionaryHeadwordImport = dictionaryHeadwordImportMapper.toEntity(dictionaryHeadwordImportDto);
        var savedDictionaryHeadword = processHeadword(dictionaryHeadwordImport.getHeadword());
        log.info("DictionaryHeadwordImport created with id: {}", savedDictionaryHeadword.getId());
        dictionaryHeadwordImport.setHeadword(savedDictionaryHeadword);
        return dictionaryHeadwordImportMapper.toDto(dictionaryHeadwordImport);
    }

    private DictionaryHeadword processHeadword(DictionaryHeadword headword) {

        var dictionary = headword.getDictionary();
        var foundDictionary = dictionaryRepository.findByName(dictionary.getName())
                .orElseThrow(() -> new ResourceNotFoundException("Dictionary not found with name: " + dictionary.getName()));

        var existing = dictionaryHeadwordRepository
                .findByDictionaryAndTitle(foundDictionary, headword.getTitle())
                .orElse(null);

        if (existing != null) {
            return existing;
        }

        headword.setDictionary(foundDictionary);
        headword.setEntries(
                headword.getEntries().stream()
                        .map(entry -> this.processEntry(headword, entry))
                        .toList()
        );
        return dictionaryHeadwordRepository.save(headword);
    }

    private DictionaryEntry processEntry(DictionaryHeadword headword, DictionaryEntry entry) {
        var lexeme = processLexeme(entry.getLexeme());
        entry.setHeadword(headword);
        entry.setLexeme(lexeme);
        entry.getSenses().forEach(sense -> {
            sense.setEntry(entry);
        });
        return entry;
    }

    private Lexeme processLexeme(Lexeme lexeme) {
        var word = processWord(lexeme.getWord());
        var partOfSpeech = processPartOfSpeech(lexeme.getPartOfSpeech());

        var existing = lexemeRepository
                .findByWordAndPartOfSpeech(word, partOfSpeech)
                .orElse(null);

        if (existing != null) {
            return existing;
        }

        lexeme.setWord(word);
        lexeme.setPartOfSpeech(partOfSpeech);
        lexeme.setWordForms(
                lexeme.getWordForms().stream()
                        .map((wordForm) -> processWordForm(lexeme, wordForm))
                        .toList()
        );
        return lexemeRepository.save(lexeme);
    }

    private Word processWord(Word word) {
        return wordRepository
                .findByLanguageAndNotation(word.getLanguage(), word.getNotation())
                .orElseGet(() -> wordRepository.save(word));
    }

    private PartOfSpeech processPartOfSpeech(PartOfSpeech pos) {
        return partOfSpeechRepository
                .findByName(pos.getName())
                .orElseGet(() -> partOfSpeechRepository.save(pos));
    }

    private WordForm processWordForm(Lexeme lexeme, WordForm wordForm) {
        var word = processWord(wordForm.getWord());
        var form = processForm(wordForm.getForm());
        wordForm.setLexeme(lexeme);
        wordForm.setWord(word);
        wordForm.setForm(form);
        return wordForm;
    }

    private Form processForm(Form form) {
        return formRepository
                .findByName(form.getName())
                .orElseGet(() -> formRepository.save(form));
    }
}
