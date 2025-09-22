package com.lingosphinx.dictionary.service;

import com.lingosphinx.dictionary.dto.VocabularySearchDto;

public interface VocabularySearchService {
    VocabularySearchDto search(VocabularySearchDto vocabularySearch);
}
