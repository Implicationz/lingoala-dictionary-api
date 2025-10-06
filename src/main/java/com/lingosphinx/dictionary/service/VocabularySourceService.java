package com.lingosphinx.dictionary.service;

import com.lingosphinx.dictionary.domain.LanguageCode;
import com.lingosphinx.dictionary.dto.VocabularySourceDto;

import java.util.List;

public interface VocabularySourceService {
    VocabularySourceDto create(VocabularySourceDto vocabularySource);
    VocabularySourceDto readById(Long id);
    List<VocabularySourceDto> readAll(LanguageCode language, String title);
    VocabularySourceDto update(Long id, VocabularySourceDto vocabularySource);
    void delete(Long id);
}
