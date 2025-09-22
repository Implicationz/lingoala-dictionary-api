package com.lingosphinx.dictionary.service;

import com.lingosphinx.dictionary.dto.DictionaryHeadwordDto;

import java.util.List;

public interface DictionaryHeadwordService {
    DictionaryHeadwordDto create(DictionaryHeadwordDto vocabulary);
    DictionaryHeadwordDto readById(Long id);
    List<DictionaryHeadwordDto> readAll();
    DictionaryHeadwordDto update(Long id, DictionaryHeadwordDto vocabulary);
    void delete(Long id);
}
