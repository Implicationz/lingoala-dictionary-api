package com.lingosphinx.dictionary.service;

import com.lingosphinx.dictionary.domain.Lexeme;
import com.lingosphinx.dictionary.domain.WordForm;
import com.lingosphinx.dictionary.dto.LexemeDto;
import com.lingosphinx.dictionary.dto.WordFormDto;
import com.lingosphinx.dictionary.exception.ResourceNotFoundException;
import com.lingosphinx.dictionary.mapper.LexemeMapper;
import com.lingosphinx.dictionary.repository.LexemeRepository;
import com.lingosphinx.dictionary.repository.LexemeSpecifications;
import com.lingosphinx.dictionary.utility.EntitySyncUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class LexemeServiceImpl implements LexemeService {

    private final LexemeRepository lexemeRepository;
    private final LexemeMapper lexemeMapper;

    @Override
    public LexemeDto create(LexemeDto lexemeDto) {
        var lexeme = lexemeMapper.toEntity(lexemeDto);
        var savedLexeme = lexemeRepository.save(lexeme);
        log.info("Lexeme created with id: {}", savedLexeme.getId());
        return lexemeMapper.toDto(savedLexeme);
    }

    @Override
    @Transactional(readOnly = true)
    public LexemeDto readById(Long id) {
        var lexeme = lexemeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Lexeme not found"));
        log.info("Lexeme found with id: {}", id);
        return lexemeMapper.toDto(lexeme);
    }

    @Override
    @Transactional(readOnly = true)
    public List<LexemeDto> readAll(String word) {
        List<Lexeme> lexemes;
        if (word != null && !word.isBlank()) {
            lexemes = lexemeRepository.findAll(LexemeSpecifications.wordNotationFuzzy(word));
        } else {
            lexemes = lexemeRepository.findAll();
        }
        log.info("Reading all lexemes with word filter: {}", word);
        return lexemeMapper.toDtoList(lexemes);
    }


    @Override
    public LexemeDto update(Long id, LexemeDto lexemeDto) {
        var existingLexeme = lexemeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Lexeme not found"));
        lexemeMapper.updateEntityFromDto(lexemeDto, existingLexeme);
        EntitySyncUtils.syncChildEntities(existingLexeme.getWordForms(), lexemeDto.getWordForms(),
                WordForm::getId,
                WordFormDto::getId,
                lexemeMapper::toEntity,
                wordForm -> wordForm.setLexeme(existingLexeme),
                lexemeMapper::updateEntityFromDto
                );
        lexemeRepository.flush();
        log.info("Lexeme updated with id: {}", id);
        return lexemeMapper.toDto(existingLexeme);
    }

    @Override
    public void delete(Long id) {
        lexemeRepository.deleteById(id);
        log.info("Lexeme deleted with id: {}", id);
    }
}