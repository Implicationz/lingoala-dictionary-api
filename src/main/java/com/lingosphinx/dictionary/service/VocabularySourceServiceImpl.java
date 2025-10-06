package com.lingosphinx.dictionary.service;


import com.lingosphinx.dictionary.domain.LanguageCode;
import com.lingosphinx.dictionary.domain.VocabularyLearner;
import com.lingosphinx.dictionary.domain.VocabularySource;
import com.lingosphinx.dictionary.domain.WordForm;
import com.lingosphinx.dictionary.dto.VocabularySourceDto;
import com.lingosphinx.dictionary.exception.ResourceNotFoundException;
import com.lingosphinx.dictionary.mapper.VocabularySourceMapper;
import com.lingosphinx.dictionary.repository.VocabularySourceRepository;
import com.lingosphinx.dictionary.repository.VocabularySourceSpecifications;
import com.lingosphinx.dictionary.repository.WordFormSpecifications;
import com.lingosphinx.dictionary.utility.EntitySyncUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class VocabularySourceServiceImpl implements VocabularySourceService {

    private final VocabularySourceRepository vocabularySourceRepository;
    private final VocabularySourceMapper vocabularySourceMapper;
    private final VocabularyLearnerService vocabularyLearnerService;

    @Override
    public VocabularySourceDto create(VocabularySourceDto vocabularySourceDto) {
        var vocabularySource = vocabularySourceMapper.toEntity(vocabularySourceDto);
        var savedVocabularySource = vocabularySourceRepository.save(vocabularySource);
        log.info("VocabularySource created with id: {}", savedVocabularySource.getId());
        return vocabularySourceMapper.toDto(savedVocabularySource);
    }

    @Override
    @Transactional(readOnly = true)
    public VocabularySourceDto readById(Long id) {
        var vocabularySource = vocabularySourceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("VocabularySource not found"));
        log.info("VocabularySource found with id: {}", id);
        return vocabularySourceMapper.toDto(vocabularySource);
    }

    @Override
    @Transactional(readOnly = true)
    public List<VocabularySourceDto> readAll(LanguageCode language, String title) {
        log.info("Reading all vocabularySources");

        var learner = vocabularyLearnerService.readCurrent();

        Specification<VocabularySource> spec = VocabularySourceSpecifications.learnerEquals(learner);

        if (title != null && !title.isBlank()) {
            spec = spec.and(VocabularySourceSpecifications.titleFuzzy(title));
        }
        if (language != null) {
            spec = spec.and(VocabularySourceSpecifications.languageEquals(language));
        }

        return vocabularySourceMapper.toDtoList(vocabularySourceRepository.findAll(spec));
    }


    @Override
    public VocabularySourceDto update(Long id, VocabularySourceDto vocabularySourceDto) {
        var existingVocabularySource = vocabularySourceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("VocabularySource not found"));
        vocabularySourceMapper.updateEntityFromDto(vocabularySourceDto, existingVocabularySource);
        log.info("VocabularySource updated with id: {}", id);
        return vocabularySourceMapper.toDto(existingVocabularySource);
    }

    @Override
    public void delete(Long id) {
        vocabularySourceRepository.deleteById(id);
        log.info("VocabularySource deleted with id: {}", id);
    }
}