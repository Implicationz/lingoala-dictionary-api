package com.lingosphinx.dictionary.mapper;

import com.lingosphinx.dictionary.domain.VocabularyEncounter;
import com.lingosphinx.dictionary.domain.VocabularyEntry;
import com.lingosphinx.dictionary.dto.VocabularyEncounterDto;
import com.lingosphinx.dictionary.dto.VocabularyEntryDto;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface VocabularyEncounterMapper {
    VocabularyEncounterDto toDto(VocabularyEncounter vocabularyEncounter);
    VocabularyEncounter toEntity(VocabularyEncounterDto vocabularyEncounterDto);

    @Mapping(target = "encounters", ignore = true)
    VocabularyEntryDto toDto(VocabularyEntry vocabularyEntry);
    @Mapping(target = "encounters", ignore = true)
    VocabularyEntry toEntity(VocabularyEntryDto vocabularyEntryDto);

    void updateEntityFromDto(VocabularyEncounterDto vocabularyEncounterDto, @MappingTarget VocabularyEncounter existingVocabularyEncounter);
}
