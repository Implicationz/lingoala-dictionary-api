package com.lingosphinx.dictionary.service;

import com.lingosphinx.dictionary.dto.VocabularyEntryDto;

import java.util.List;

public interface VocabularyEntryService {
    VocabularyEntryDto create(VocabularyEntryDto vocabularyEntry);
    VocabularyEntryDto readById(Long id);
    List<VocabularyEntryDto> readAll();
    VocabularyEntryDto update(Long id, VocabularyEntryDto vocabularyEntry);
    void delete(Long id);
}
