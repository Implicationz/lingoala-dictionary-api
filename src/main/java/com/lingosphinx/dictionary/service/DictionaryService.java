package com.lingosphinx.dictionary.service;

import com.lingosphinx.dictionary.dto.DictionaryDto;

import java.util.List;

public interface DictionaryService {
    DictionaryDto create(DictionaryDto dictionary);
    DictionaryDto readById(Long id);
    List<DictionaryDto> readAll();
    DictionaryDto update(Long id, DictionaryDto dictionary);
    void delete(Long id);
}
