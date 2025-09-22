package com.lingosphinx.dictionary.service;

import com.lingosphinx.dictionary.domain.DictionaryEntry;
import com.lingosphinx.dictionary.dto.DictionaryEntryDto;
import com.lingosphinx.dictionary.dto.DictionaryHeadwordDto;
import com.lingosphinx.dictionary.exception.ResourceNotFoundException;
import com.lingosphinx.dictionary.mapper.DictionaryHeadwordMapper;
import com.lingosphinx.dictionary.repository.DictionaryHeadwordRepository;
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
public class DictionaryHeadwordServiceImpl implements DictionaryHeadwordService {

    private final DictionaryHeadwordRepository dictionaryHeadwordRepository;
    private final DictionaryHeadwordMapper dictionaryHeadwordMapper;

    @Override
    public DictionaryHeadwordDto create(DictionaryHeadwordDto dictionaryHeadwordDto) {
        var dictionaryHeadword = dictionaryHeadwordMapper.toEntity(dictionaryHeadwordDto);
        var savedDictionaryHeadword = dictionaryHeadwordRepository.save(dictionaryHeadword);
        log.info("DictionaryHeadword created with id: {}", savedDictionaryHeadword.getId());
        return dictionaryHeadwordMapper.toDto(savedDictionaryHeadword);
    }

    @Override
    @Transactional(readOnly = true)
    public DictionaryHeadwordDto readById(Long id) {
        var dictionaryHeadword = dictionaryHeadwordRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("DictionaryHeadword not found"));
        log.info("DictionaryHeadword found with id: {}", id);
        return dictionaryHeadwordMapper.toDto(dictionaryHeadword);
    }

    @Override
    @Transactional(readOnly = true)
    public List<DictionaryHeadwordDto> readAll() {
        log.info("Reading all dictionaryHeadwords");
        return dictionaryHeadwordRepository.findAll().stream()
                .map(dictionaryHeadwordMapper::toDto)
                .toList();
    }

    @Override
    public DictionaryHeadwordDto update(Long id, DictionaryHeadwordDto dictionaryHeadwordDto) {
        var existingDictionaryHeadword = dictionaryHeadwordRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("DictionaryHeadword not found"));
        dictionaryHeadwordMapper.updateEntityFromDto(dictionaryHeadwordDto, existingDictionaryHeadword);
        EntitySyncUtils.syncChildEntities(existingDictionaryHeadword.getEntries(), dictionaryHeadwordDto.getEntries(),
                DictionaryEntry::getId,
                DictionaryEntryDto::getId,
                dictionaryHeadwordMapper::toEntity,
                dictionaryHeadwordEntry -> dictionaryHeadwordEntry.setHeadword(existingDictionaryHeadword),
                dictionaryHeadwordMapper::updateEntityFromDto
                );
        dictionaryHeadwordRepository.flush();
        log.info("DictionaryHeadword updated with id: {}", id);
        return dictionaryHeadwordMapper.toDto(existingDictionaryHeadword);
    }

    @Override
    public void delete(Long id) {
        dictionaryHeadwordRepository.deleteById(id);
        log.info("DictionaryHeadword deleted with id: {}", id);
    }
}