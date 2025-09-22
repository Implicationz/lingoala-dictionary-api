package com.lingosphinx.dictionary.service;

import com.lingosphinx.dictionary.domain.VocabularySearch;
import com.lingosphinx.dictionary.dto.VocabularySearchDto;
import com.lingosphinx.dictionary.mapper.VocabularySearchMapper;
import com.lingosphinx.dictionary.repository.VocabularyEntryRepository;
import com.lingosphinx.dictionary.repository.VocabularySearchSpecifications;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class VocabularySearchServiceImpl implements VocabularySearchService {

    private final VocabularyLearnerService vocabularyLearnerService;
    private final VocabularyEntryRepository vocabularyEntryRepository;
    private final VocabularySearchMapper vocabularySearchMapper;

    @Override
    public VocabularySearchDto search(VocabularySearchDto vocabularySearchDto) {
        var vocabularySearch = vocabularySearchMapper.toEntity(vocabularySearchDto);
        var vocabularyLearner = this.vocabularyLearnerService.readCurrent();
        log.info("Performing fuzzy search for headwords with term '{}' in vocabularyLearner '{}'", vocabularySearch.getTerm(), vocabularyLearner.getId());

        var spec = VocabularySearchSpecifications.fuzzyLexemeAndLearner(
            vocabularySearch.getTerm(),
            vocabularyLearner
        );

        var entries = vocabularyEntryRepository.findAll(spec);

        var result = VocabularySearch.builder()
                .term(vocabularySearch.getTerm())
                .entries(entries)
                .build();

        return vocabularySearchMapper.toDto(result);
    }

}
