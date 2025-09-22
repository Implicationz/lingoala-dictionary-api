package com.lingosphinx.dictionary.service;

import com.lingosphinx.dictionary.domain.DictionaryHeadword;
import com.lingosphinx.dictionary.dto.DictionaryDto;
import com.lingosphinx.dictionary.dto.DictionaryHeadwordDto;
import com.lingosphinx.dictionary.exception.ResourceNotFoundException;
import com.lingosphinx.dictionary.mapper.DictionaryMapper;
import com.lingosphinx.dictionary.repository.DictionaryRepository;
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
public class DictionaryServiceImpl implements DictionaryService {

    private final DictionaryRepository dictionaryRepository;
    private final DictionaryMapper dictionaryMapper;

    @Override
    public DictionaryDto create(DictionaryDto dictionaryDto) {
        var dictionary = dictionaryMapper.toEntity(dictionaryDto);
        var savedDictionary = dictionaryRepository.save(dictionary);
        log.info("Dictionary created with id: {}", savedDictionary.getId());
        return dictionaryMapper.toDto(savedDictionary);
    }

    @Override
    @Transactional(readOnly = true)
    public DictionaryDto readById(Long id) {
        var dictionary = dictionaryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Dictionary not found"));
        log.info("Dictionary found with id: {}", id);
        return dictionaryMapper.toDto(dictionary);
    }

    @Override
    @Transactional(readOnly = true)
    public List<DictionaryDto> readAll() {
        log.info("Reading all dictionarys");
        return dictionaryRepository.findAll().stream()
                .map(dictionaryMapper::toDto)
                .toList();
    }

    @Override
    public DictionaryDto update(Long id, DictionaryDto dictionaryDto) {
        var existingDictionary = dictionaryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Dictionary not found"));
        dictionaryMapper.updateEntityFromDto(dictionaryDto, existingDictionary);
        EntitySyncUtils.syncChildEntities(existingDictionary.getHeadwords(), dictionaryDto.getHeadwords(),
                DictionaryHeadword::getId,
                DictionaryHeadwordDto::getId,
                dictionaryMapper::toEntity,
                headword -> headword.setDictionary(existingDictionary),
                dictionaryMapper::updateEntityFromDto
                );
        dictionaryRepository.flush();
        log.info("Dictionary updated with id: {}", id);
        return dictionaryMapper.toDto(existingDictionary);
    }

    @Override
    public void delete(Long id) {
        dictionaryRepository.deleteById(id);
        log.info("Dictionary deleted with id: {}", id);
    }
}