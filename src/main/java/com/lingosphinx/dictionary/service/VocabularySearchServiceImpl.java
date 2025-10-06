package com.lingosphinx.dictionary.service;

import com.lingosphinx.dictionary.domain.VocabularySearch;
import com.lingosphinx.dictionary.domain.VocabularySearchHit;
import com.lingosphinx.dictionary.dto.VocabularySearchDto;
import com.lingosphinx.dictionary.exception.ResourceNotFoundException;
import com.lingosphinx.dictionary.mapper.VocabularySearchMapper;
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
public class VocabularySearchServiceImpl implements VocabularySearchService {

    private final UserService userService;
    private final VocabularyRepository vocabularyRepository;
    private final VocabularyEntryRepository vocabularyEntryRepository;
    private final VocabularySearchMapper vocabularySearchMapper;

    @Override
    public VocabularySearchDto search(VocabularySearchDto vocabularySearchDto) {
        var vocabularySearch = vocabularySearchMapper.toEntity(vocabularySearchDto);
        var userId = userService.getCurrentUserId();
        log.info("Performing fuzzy search for entries with term '{}' in userId '{}'", vocabularySearch.getTerm(), userId);

        var vocabulary = vocabularyRepository
                .findByLearner_UserIdAndLanguage(userId, vocabularySearch.getLanguage())
                .orElseThrow(() -> new ResourceNotFoundException("Vocabulary not found for userId " + userId + " and language " + vocabularySearch.getLanguage().getValue()));

        var found = vocabularyEntryRepository.findSearchHitsByWordForm(vocabulary, vocabularySearchDto.getTerm());
        
        var hits = VocabularySearchHit.fromProjections(found.stream());

        var result = VocabularySearch.builder()
                .term(vocabularySearchDto.getTerm())
                .hits(hits)
                .build();

        return vocabularySearchMapper.toDto(result);
    }

}
