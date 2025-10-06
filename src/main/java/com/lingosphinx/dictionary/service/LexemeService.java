package com.lingosphinx.dictionary.service;

import com.lingosphinx.dictionary.dto.LexemeDto;

import java.util.List;

public interface LexemeService {
    LexemeDto create(LexemeDto lexeme);
    LexemeDto readById(Long id);
    List<LexemeDto> readAll(String word);
    LexemeDto update(Long id, LexemeDto lexeme);
    void delete(Long id);
}
