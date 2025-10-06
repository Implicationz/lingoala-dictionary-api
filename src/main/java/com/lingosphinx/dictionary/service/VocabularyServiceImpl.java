package com.lingosphinx.dictionary.service;

import com.lingosphinx.dictionary.domain.VocabularyEntry;
import com.lingosphinx.dictionary.dto.VocabularyDto;
import com.lingosphinx.dictionary.dto.VocabularyEntryDto;
import com.lingosphinx.dictionary.exception.ResourceNotFoundException;
import com.lingosphinx.dictionary.mapper.VocabularyMapper;
import com.lingosphinx.dictionary.repository.VocabularyRepository;
import com.lingosphinx.dictionary.utility.EntitySyncUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class VocabularyServiceImpl implements VocabularyService {

    private final VocabularyRepository vocabularyRepository;
    private final VocabularyMapper vocabularyMapper;

    @Override
    public VocabularyDto create(VocabularyDto vocabularyDto) {
        var vocabulary = vocabularyMapper.toEntity(vocabularyDto);
        var savedVocabulary = vocabularyRepository.save(vocabulary);
        log.info("Vocabulary created with id: {}", savedVocabulary.getId());
        return vocabularyMapper.toDto(savedVocabulary);
    }

    @Override
    @Transactional(readOnly = true)
    public VocabularyDto readById(Long id) {
        var vocabulary = vocabularyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vocabulary not found"));
        log.info("Vocabulary found with id: {}", id);
        return vocabularyMapper.toDto(vocabulary);
    }

    @Override
    @Transactional(readOnly = true)
    public List<VocabularyDto> readAll() {
        log.info("Reading all vocabularys");
        return vocabularyRepository.findAll().stream()
                .map(vocabularyMapper::toDto)
                .toList();
    }

    @Override
    public VocabularyDto update(Long id, VocabularyDto vocabularyDto) {
        var existingVocabulary = vocabularyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vocabulary not found"));
        vocabularyMapper.updateEntityFromDto(vocabularyDto, existingVocabulary);
        EntitySyncUtils.syncChildEntities(existingVocabulary.getEntries(), vocabularyDto.getEntries(),
                VocabularyEntry::getId,
                VocabularyEntryDto::getId,
                vocabularyMapper::toEntity,
                vocabularyEntry -> vocabularyEntry.setVocabulary(existingVocabulary),
                vocabularyMapper::updateEntityFromDto
                );
        vocabularyRepository.flush();
        log.info("Vocabulary updated with id: {}", id);
        return vocabularyMapper.toDto(existingVocabulary);
    }

    @Override
    public void delete(Long id) {
        vocabularyRepository.deleteById(id);
        log.info("Vocabulary deleted with id: {}", id);
    }
}