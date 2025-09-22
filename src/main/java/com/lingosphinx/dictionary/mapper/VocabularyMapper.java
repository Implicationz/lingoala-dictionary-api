package com.lingosphinx.dictionary.mapper;

import com.lingosphinx.dictionary.domain.Vocabulary;
import com.lingosphinx.dictionary.domain.VocabularyEntry;
import com.lingosphinx.dictionary.dto.VocabularyDto;
import com.lingosphinx.dictionary.dto.VocabularyEntryDto;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface VocabularyMapper {
    VocabularyDto toDto(Vocabulary vocabulary);
    Vocabulary toEntity(VocabularyDto vocabularyDto);

    @Mapping(target = "vocabulary", ignore = true)
    VocabularyEntryDto toDto(VocabularyEntry vocabularyEntry);
    @Mapping(target = "vocabulary", ignore = true)
    VocabularyEntry toEntity(VocabularyEntryDto VocabularyEntryDto);

    @Mapping(target = "entries", ignore = true)
    void updateEntityFromDto(VocabularyDto vocabularyDto, @MappingTarget Vocabulary vocabulary);

    @Mapping(target = "vocabulary", ignore = true)
    void updateEntityFromDto(VocabularyEntryDto vocabularyEntryDto, @MappingTarget VocabularyEntry vocabularyEntry);
}
