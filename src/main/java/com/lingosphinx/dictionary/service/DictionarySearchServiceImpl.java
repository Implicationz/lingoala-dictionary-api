package com.lingosphinx.dictionary.service;

import com.lingosphinx.dictionary.domain.Dictionary;
import com.lingosphinx.dictionary.domain.DictionarySearch;
import com.lingosphinx.dictionary.domain.DictionarySearchHit;
import com.lingosphinx.dictionary.dto.DictionarySearchDto;
import com.lingosphinx.dictionary.exception.ResourceNotFoundException;
import com.lingosphinx.dictionary.mapper.DictionarySearchMapper;
import com.lingosphinx.dictionary.repository.DictionaryEntryRepository;
import com.lingosphinx.dictionary.repository.DictionaryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class DictionarySearchServiceImpl implements DictionarySearchService {

    private final DictionaryEntryRepository dictionaryEntryRepository;
    private final DictionaryRepository dictionaryRepository;
    private final DictionarySearchMapper dictionarySearchMapper;

    @Override
    public DictionarySearchDto search(DictionarySearchDto dictionarySearchDto) {
        var dictionarySearch = dictionarySearchMapper.toEntity(dictionarySearchDto);
        var dictionary = this.dictionaryRepository
                .findByName(dictionarySearch.getDictionary().getName())
                .orElseThrow(() -> new ResourceNotFoundException("Dictionary not found with name: " + dictionarySearch.getDictionary().getName()));

        log.info("Performing fuzzy search for entries with term '{}' in dictionary '{}'", dictionarySearch.getTerm(), dictionary.getId());

        var found = dictionaryEntryRepository.findSearchHitsByWordForm(dictionary, dictionarySearch.getTerm());
        var hits = DictionarySearchHit.fromProjections(found.stream());
        
        var result = DictionarySearch.builder()
                .dictionary(Dictionary.builder().name(dictionary.getName()).build())
                .term(dictionarySearch.getTerm())
                .hits(hits)
                .build();

        return dictionarySearchMapper.toDto(result);
    }

}
