package com.lingosphinx.dictionary.service;

import com.lingosphinx.dictionary.domain.VocabularyLearner;
import com.lingosphinx.dictionary.dto.VocabularyLearnerDto;

import java.util.List;

public interface VocabularyLearnerService {

    VocabularyLearner registerCurrent();

    VocabularyLearnerDto create(VocabularyLearnerDto account);

    VocabularyLearnerDto readById(Long id);
    List<VocabularyLearnerDto> readAll();
    VocabularyLearnerDto update(Long id, VocabularyLearnerDto account);
    void delete(Long id);

    VocabularyLearner readCurrent();


}
