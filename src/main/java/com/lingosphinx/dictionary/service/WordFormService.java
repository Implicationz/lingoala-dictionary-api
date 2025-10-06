package com.lingosphinx.dictionary.service;

import com.lingosphinx.dictionary.dto.WordFormDto;

import java.util.List;

public interface WordFormService {
    WordFormDto create(WordFormDto wordForm);
    WordFormDto readById(Long id);
    WordFormDto update(Long id, WordFormDto wordForm);
    void delete(Long id);

    List<WordFormDto> readAll(String word, String lexeme);
}
