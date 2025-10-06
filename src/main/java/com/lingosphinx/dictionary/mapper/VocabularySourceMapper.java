package com.lingosphinx.dictionary.mapper;

import com.lingosphinx.dictionary.domain.*;
import com.lingosphinx.dictionary.domain.VocabularySource;
import com.lingosphinx.dictionary.dto.*;
import com.lingosphinx.dictionary.dto.VocabularySourceDto;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface VocabularySourceMapper {
    VocabularySourceDto toDto(VocabularySource vocabularySource);
    VocabularySource toEntity(VocabularySourceDto vocabularySourceDto);

    @Mapping(target = "vocabularies", ignore = true)
    VocabularyLearnerDto toDto(VocabularyLearner vocabularyLearner);
    @Mapping(target = "vocabularies", ignore = true)
    VocabularyLearner toEntity(VocabularyLearnerDto vocabularyLearnerDto);

    @Mapping(target = "source", ignore = true)
    VocabularyEncounterDto toDto(VocabularyEncounter vocabularyEncounter);
    @Mapping(target = "source", ignore = true)
    VocabularyEncounter toEntity(VocabularyEncounterDto vocabularyEncounterDto);

    void updateEntityFromDto(VocabularySourceDto vocabularySourceDto, @MappingTarget VocabularySource existingVocabularySource);

    default List<VocabularySourceDto> toDtoList(List<VocabularySource> vocabularySources) {
        return vocabularySources.stream()
                .map(this::toDtoList)
                .toList();
    }

    @Mapping(target = "learner", ignore = true)
    @Mapping(target = "encounters", ignore = true)
    VocabularySourceDto toDtoList(VocabularySource vocabularySource);
}
