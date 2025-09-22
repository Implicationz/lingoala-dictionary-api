package com.lingosphinx.dictionary.mapper;

import com.lingosphinx.dictionary.domain.VocabularyEntry;
import com.lingosphinx.dictionary.domain.VocabularySearch;
import com.lingosphinx.dictionary.dto.VocabularyEntryDto;
import com.lingosphinx.dictionary.dto.VocabularySearchDto;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface VocabularySearchMapper {
    VocabularySearchDto toDto(VocabularySearch vocabularySearch);
    VocabularySearch toEntity(VocabularySearchDto vocabularySearchDto);

    @Mapping(target = "vocabulary", ignore = true)
    VocabularyEntryDto toDto(VocabularyEntry vocabularyEntry);
    @Mapping(target = "vocabulary", ignore = true)
    VocabularyEntry toEntity(VocabularyEntryDto VocabularyEntryDto);
}
