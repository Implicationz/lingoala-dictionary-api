package com.lingosphinx.dictionary.service;

import com.lingosphinx.dictionary.dto.VocabularyDto;

import java.util.List;

public interface VocabularyService {
    VocabularyDto create(VocabularyDto vocabulary);
    VocabularyDto readById(Long id);
    List<VocabularyDto> readAll();
    VocabularyDto update(Long id, VocabularyDto vocabulary);
    void delete(Long id);
}
