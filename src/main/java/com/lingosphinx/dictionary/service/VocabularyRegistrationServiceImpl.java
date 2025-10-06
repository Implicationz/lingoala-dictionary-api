package com.lingosphinx.dictionary.service;

import com.lingosphinx.dictionary.domain.Vocabulary;
import com.lingosphinx.dictionary.domain.VocabularyRegistration;
import com.lingosphinx.dictionary.dto.VocabularyRegistrationDto;
import com.lingosphinx.dictionary.mapper.VocabularyRegistrationMapper;
import com.lingosphinx.dictionary.repository.VocabularyEntryRepository;
import com.lingosphinx.dictionary.repository.VocabularyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class VocabularyRegistrationServiceImpl implements VocabularyRegistrationService {

    private final VocabularyLearnerService vocabularyLearnerService;
    private final VocabularyEntryRepository vocabularyEntryRepository;
    private final VocabularyRepository vocabularyRepository;
    private final VocabularyRegistrationMapper vocabularyRegistrationMapper;

    @Override
    public VocabularyRegistrationDto register(VocabularyRegistrationDto vocabularyRegistrationDto) {
        var vocabularyRegistration = vocabularyRegistrationMapper.toEntity(vocabularyRegistrationDto);
        var vocabularyLearner = this.vocabularyLearnerService.registerCurrent();
        var language = vocabularyRegistration.getLanguage();
        log.info("Registration of '{}' for vocabularyLearner '{}'", language.getValue(), vocabularyLearner.getId());

        var vocabulary = vocabularyRepository
                .findByLearnerAndLanguage(vocabularyLearner, language)
                .orElseGet(() -> {
                    var newVocabulary = Vocabulary.builder()
                            .learner(vocabularyLearner)
                            .language(language)
                            .build();
                    return vocabularyRepository.save(newVocabulary);
                });

        var entries = vocabularyEntryRepository.findAllByVocabulary(vocabulary);
        var result = VocabularyRegistration.builder()
                .language(language)
                .entries(entries)
                .build();

        return vocabularyRegistrationMapper.toDto(result);
    }

}
