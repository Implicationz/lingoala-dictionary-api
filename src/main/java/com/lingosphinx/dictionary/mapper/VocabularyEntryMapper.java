package com.lingosphinx.dictionary.mapper;

import com.lingosphinx.dictionary.domain.VocabularyEntry;
import com.lingosphinx.dictionary.dto.VocabularyEntryDto;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface VocabularyEntryMapper {
    VocabularyEntryDto toDto(VocabularyEntry vocabularyEntry);
    VocabularyEntry toEntity(VocabularyEntryDto vocabularyEntryDto);

    void updateEntityFromDto(VocabularyEntryDto vocabularyEntryDto, @MappingTarget VocabularyEntry existingVocabularyEntry);
}
