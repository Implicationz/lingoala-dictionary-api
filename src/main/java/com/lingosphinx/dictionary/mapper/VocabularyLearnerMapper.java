package com.lingosphinx.dictionary.mapper;

import com.lingosphinx.dictionary.domain.VocabularyLearner;
import com.lingosphinx.dictionary.dto.VocabularyLearnerDto;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface VocabularyLearnerMapper {
    VocabularyLearnerDto toDto(VocabularyLearner vocabularyLearner);
    VocabularyLearner toEntity(VocabularyLearnerDto vocabularyLearnerDto);

    void toEntityFromDto(VocabularyLearnerDto vocabularyLearnerDto, @MappingTarget VocabularyLearner existingVocabularyLearner);
}
