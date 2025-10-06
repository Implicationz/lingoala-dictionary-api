package com.lingosphinx.dictionary.service;

import com.lingosphinx.dictionary.dto.VocabularyEncounterDto;
import com.lingosphinx.dictionary.dto.VocabularyEncounterEventDto;
import com.lingosphinx.dictionary.exception.ResourceNotFoundException;
import com.lingosphinx.dictionary.mapper.VocabularyEncounterMapper;
import com.lingosphinx.dictionary.repository.VocabularyEncounterRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class VocabularyEncounterServiceImpl implements VocabularyEncounterService {

    private final VocabularyEncounterRepository vocabularyEncounterRepository;
    private final VocabularyEncounterMapper vocabularyEncounterMapper;

    @Override
    public VocabularyEncounterDto create(VocabularyEncounterDto vocabularyEncounterDto) {
        var vocabularyEncounter = vocabularyEncounterMapper.toEntity(vocabularyEncounterDto);
        var savedVocabularyEncounter = vocabularyEncounterRepository.save(vocabularyEncounter);
        log.info("VocabularyEncounter created with id: {}", savedVocabularyEncounter.getId());
        return vocabularyEncounterMapper.toDto(savedVocabularyEncounter);
    }

    @Override
    @Transactional(readOnly = true)
    public VocabularyEncounterDto readById(Long id) {
        var vocabularyEncounter = vocabularyEncounterRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("VocabularyEncounter not found"));
        log.info("VocabularyEncounter found with id: {}", id);
        return vocabularyEncounterMapper.toDto(vocabularyEncounter);
    }

    @Override
    @Transactional(readOnly = true)
    public List<VocabularyEncounterDto> readAll() {
        log.info("Reading all vocabularyEncounters");
        return vocabularyEncounterRepository.findAll().stream()
                .map(vocabularyEncounterMapper::toDto)
                .toList();
    }

    @Override
    public VocabularyEncounterDto update(Long id, VocabularyEncounterDto vocabularyEncounterDto) {
        var existingVocabularyEncounter = vocabularyEncounterRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("VocabularyEncounter not found"));
        vocabularyEncounterMapper.updateEntityFromDto(vocabularyEncounterDto, existingVocabularyEncounter);
        log.info("VocabularyEncounter updated with id: {}", id);
        return vocabularyEncounterMapper.toDto(existingVocabularyEncounter);
    }

    @Override
    public void delete(Long id) {
        vocabularyEncounterRepository.deleteById(id);
        log.info("VocabularyEncounter deleted with id: {}", id);
    }

    @Override
    public VocabularyEncounterEventDto handle(VocabularyEncounterEventDto vocabularyEncounterEvent) {
        var vocabularyEncounter = vocabularyEncounterMapper.toEntity(vocabularyEncounterEvent.getEncounter());
        var savedEncounter = vocabularyEncounterRepository.save(vocabularyEncounter);
        return null;
    }
}