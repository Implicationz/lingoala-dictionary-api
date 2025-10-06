package com.lingosphinx.dictionary.service;

import com.lingosphinx.dictionary.domain.WordForm;
import com.lingosphinx.dictionary.dto.WordFormDto;
import com.lingosphinx.dictionary.exception.ResourceNotFoundException;
import com.lingosphinx.dictionary.mapper.WordFormMapper;
import com.lingosphinx.dictionary.repository.WordFormRepository;
import com.lingosphinx.dictionary.repository.WordFormSpecifications;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class WordFormServiceImpl implements WordFormService {

    private final WordFormRepository wordFormRepository;
    private final WordFormMapper wordFormMapper;

    @Override
    public WordFormDto create(WordFormDto wordFormDto) {
        var wordForm = wordFormMapper.toEntity(wordFormDto);
        var savedWordForm = wordFormRepository.save(wordForm);
        log.info("WordForm created with id: {}", savedWordForm.getId());
        return wordFormMapper.toDto(savedWordForm);
    }

    @Override
    @Transactional(readOnly = true)
    public WordFormDto readById(Long id) {
        var wordForm = wordFormRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("WordForm not found"));
        log.info("WordForm found with id: {}", id);
        return wordFormMapper.toDto(wordForm);
    }

    @Override
    @Transactional(readOnly = true)
    public List<WordFormDto> readAll(String word, String lexeme) {
        Specification<WordForm> spec = Specification.where(null);

        if (word != null && !word.isBlank()) {
            spec = spec.and(WordFormSpecifications.wordNotationFuzzy(word));
        }
        if (lexeme != null && !lexeme.isBlank()) {
            spec = spec.and(WordFormSpecifications.lexemeNotationEquals(lexeme));
        }

        var wordForms = wordFormRepository.findAll(spec);
        log.info("Reading all wordForms with word: {}, lexeme: {}", word, lexeme);
        return wordFormMapper.toDtoList(wordForms);
    }

    @Override
    public WordFormDto update(Long id, WordFormDto wordFormDto) {
        var existingWordForm = wordFormRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("WordForm not found"));
        wordFormMapper.updateEntityFromDto(wordFormDto, existingWordForm);
        log.info("WordForm updated with id: {}", id);
        return wordFormMapper.toDto(existingWordForm);
    }

    @Override
    public void delete(Long id) {
        wordFormRepository.deleteById(id);
        log.info("WordForm deleted with id: {}", id);
    }
}