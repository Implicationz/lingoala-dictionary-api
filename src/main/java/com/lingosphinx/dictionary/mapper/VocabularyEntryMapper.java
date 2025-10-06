package com.lingosphinx.dictionary.mapper;

import com.lingosphinx.dictionary.domain.*;
import com.lingosphinx.dictionary.dto.*;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface VocabularyEntryMapper {
    VocabularyEntryDto toDto(VocabularyEntry vocabularyEntry);
    VocabularyEntry toEntity(VocabularyEntryDto vocabularyEntryDto);

    @Mapping(target = "entries", ignore = true)
    VocabularyDto toDto(Vocabulary vocabulary);
    @Mapping(target = "entries", ignore = true)
    Vocabulary toEntity(VocabularyDto vocabularyDto);

    @Mapping(target = "vocabularies", ignore = true)
    VocabularyLearnerDto toDto(VocabularyLearner vocabularyLearner);
    @Mapping(target = "vocabularies", ignore = true)
    VocabularyLearner toEntity(VocabularyLearnerDto vocabularyLearnerDto);

    @Mapping(target = "lexeme", ignore = true)
    WordFormDto toDto(WordForm wordForm);
    @Mapping(target = "lexeme", ignore = true)
    WordForm toEntity(WordFormDto wordFormDto);

    @Mapping(target = "entry", ignore = true)
    VocabularyEncounterDto toDto(VocabularyEncounter vocabularyEncounter);
    @Mapping(target = "entry", ignore = true)
    VocabularyEncounter toEntity(VocabularyEncounterDto vocabularyEncounterDto);

    @Mapping(target = "encounters", ignore = true)
    @Mapping(target = "lexeme", ignore = true)
    void updateEntityFromDto(VocabularyEntryDto vocabularyEntryDto, @MappingTarget VocabularyEntry existingVocabularyEntry);

    @Mapping(target = "entry", ignore = true)
    @Mapping(target = "wordForm", ignore = true)
    void updateEntityFromDto(VocabularyEncounterDto vocabularyEncounterDto, @MappingTarget VocabularyEncounter existingVocabularyEncounter);
}
