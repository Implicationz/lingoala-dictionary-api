package com.lingosphinx.dictionary.service;

import com.lingosphinx.dictionary.dto.VocabularyEntryDto;
import com.lingosphinx.dictionary.exception.ResourceNotFoundException;
import com.lingosphinx.dictionary.mapper.VocabularyEntryMapper;
import com.lingosphinx.dictionary.repository.VocabularyEntryRepository;
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
public class VocabularyEntryServiceImpl implements VocabularyEntryService {

    private final VocabularyEntryRepository vocabularyEntryRepository;
    private final VocabularyEntryMapper vocabularyEntryMapper;

    @Override
    public VocabularyEntryDto create(VocabularyEntryDto vocabularyEntryDto) {
        var vocabularyEntry = vocabularyEntryMapper.toEntity(vocabularyEntryDto);
        var savedVocabularyEntry = vocabularyEntryRepository.save(vocabularyEntry);
        log.info("VocabularyEntry created with id: {}", savedVocabularyEntry.getId());
        return vocabularyEntryMapper.toDto(savedVocabularyEntry);
    }

    @Override
    @Transactional(readOnly = true)
    public VocabularyEntryDto readById(Long id) {
        var vocabularyEntry = vocabularyEntryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("VocabularyEntry not found"));
        log.info("VocabularyEntry found with id: {}", id);
        return vocabularyEntryMapper.toDto(vocabularyEntry);
    }

    @Override
    @Transactional(readOnly = true)
    public List<VocabularyEntryDto> readAll() {
        log.info("Reading all vocabularyEntrys");
        return vocabularyEntryRepository.findAll().stream()
                .map(vocabularyEntryMapper::toDto)
                .toList();
    }

    @Override
    public VocabularyEntryDto update(Long id, VocabularyEntryDto vocabularyEntryDto) {
        var existingVocabularyEntry = vocabularyEntryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("VocabularyEntry not found"));
        vocabularyEntryMapper.updateEntityFromDto(vocabularyEntryDto, existingVocabularyEntry);
        log.info("VocabularyEntry updated with id: {}", id);
        return vocabularyEntryMapper.toDto(existingVocabularyEntry);
    }

    @Override
    public void delete(Long id) {
        vocabularyEntryRepository.deleteById(id);
        log.info("VocabularyEntry deleted with id: {}", id);
    }
}