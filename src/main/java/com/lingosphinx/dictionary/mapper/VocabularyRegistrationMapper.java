package com.lingosphinx.dictionary.mapper;

import com.lingosphinx.dictionary.domain.*;
import com.lingosphinx.dictionary.dto.*;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface VocabularyRegistrationMapper {
    VocabularyRegistrationDto toDto(VocabularyRegistration vocabularyRegistration);
    VocabularyRegistration toEntity(VocabularyRegistrationDto vocabularyRegistrationDto);

    @Mapping(target = "vocabularies", ignore = true)
    VocabularyLearnerDto toDto(VocabularyLearner vocabularyLearner);
    @Mapping(target = "vocabularies", ignore = true)
    VocabularyLearner toEntity(VocabularyLearnerDto vocabularyLearnerDto);

    @Mapping(target = "vocabulary", ignore = true)
    VocabularyEntryDto toDto(VocabularyEntry vocabularyEntry);
    @Mapping(target = "vocabulary", ignore = true)
    VocabularyEntry toEntity(VocabularyEntryDto VocabularyEntryDto);

    @Mapping(target = "entry", ignore = true)
    VocabularyEncounterDto toDto(VocabularyEncounter vocabularyEncounter);
    @Mapping(target = "entry", ignore = true)
    VocabularyEncounter toEntity(VocabularyEncounterDto vocabularyEncounterDto);

    @Mapping(target = "wordForms", ignore = true)
    LexemeDto toDto(Lexeme lexeme);
    @Mapping(target = "wordForms", ignore = true)
    Lexeme toEntity(LexemeDto lexemeDto);

    @Mapping(target = "lexeme", ignore = true)
    WordFormDto toDto(WordForm wordForm);
    @Mapping(target = "lexeme", ignore = true)
    WordForm toEntity(WordFormDto wordFormDto);
}
