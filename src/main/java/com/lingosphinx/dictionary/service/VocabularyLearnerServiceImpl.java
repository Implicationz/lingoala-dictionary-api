package com.lingosphinx.dictionary.service;


import com.lingosphinx.dictionary.domain.VocabularyLearner;
import com.lingosphinx.dictionary.dto.VocabularyLearnerDto;
import com.lingosphinx.dictionary.exception.ResourceNotFoundException;
import com.lingosphinx.dictionary.mapper.VocabularyLearnerMapper;
import com.lingosphinx.dictionary.repository.VocabularyLearnerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class VocabularyLearnerServiceImpl implements VocabularyLearnerService {

    private final UserService userService;
    private final VocabularyLearnerRepository vocabularyLearnerRepository;
    private final VocabularyLearnerMapper vocabularyLearnerMapper;

    @Override
    public VocabularyLearner registerCurrent() {
        var userId = this.userService.getCurrentUserId();
        var registered = this.vocabularyLearnerRepository.findByUserId(userId).orElseGet(() -> {
            var vocabularyLearner = new VocabularyLearner();
            vocabularyLearner.setUserId(userId);
            var savedVocabularyLearner = vocabularyLearnerRepository.save(vocabularyLearner);
            log.info("VocabularyLearner registered successfully: id={}", savedVocabularyLearner.getId());
            return savedVocabularyLearner;
        });
        return registered;
    }

    @Override
    public VocabularyLearnerDto create(VocabularyLearnerDto vocabularyLearnerDto) {
        var vocabularyLearner = vocabularyLearnerMapper.toEntity(vocabularyLearnerDto);
        var savedVocabularyLearner = vocabularyLearnerRepository.save(vocabularyLearner);
        log.info("VocabularyLearner created successfully: id={}", savedVocabularyLearner.getId());
        return vocabularyLearnerMapper.toDto(savedVocabularyLearner);
    }

    @Override
    @Transactional(readOnly = true)
    public VocabularyLearnerDto readById(Long id) {
        var vocabularyLearner = vocabularyLearnerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("VocabularyLearner not found"));
        return this.vocabularyLearnerMapper.toDto(vocabularyLearner);
    }


    @Override
    @Transactional(readOnly = true)
    public List<VocabularyLearnerDto> readAll() {
        var result = vocabularyLearnerRepository.findAll().stream()
                .map(vocabularyLearnerMapper::toDto)
                .toList();
        log.info("All vocabularyLearners read successfully, count={}", result.size());
        return result;
    }

    @Override
    public VocabularyLearnerDto update(Long id, VocabularyLearnerDto vocabularyLearnerDto) {
        var existingVocabularyLearner = vocabularyLearnerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("VocabularyLearner not found"));

        vocabularyLearnerMapper.toEntityFromDto(vocabularyLearnerDto, existingVocabularyLearner);
        log.info("VocabularyLearner updated successfully: id={}", existingVocabularyLearner.getId());
        return vocabularyLearnerMapper.toDto(existingVocabularyLearner);
    }

    @Override
    public void delete(Long id) {
        vocabularyLearnerRepository.deleteById(id);
        log.info("VocabularyLearner deleted successfully: id={}", id);
    }

    @Override
    public VocabularyLearner readCurrent() {
        var userId = this.userService.getCurrentUserId();
        return this.vocabularyLearnerRepository.findByUserId(userId).orElseThrow(() -> new ResourceNotFoundException("Current VocabularyLearner not found"));
    }

}