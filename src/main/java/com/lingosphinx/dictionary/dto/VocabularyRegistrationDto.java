package com.lingosphinx.dictionary.dto;

import com.lingosphinx.dictionary.domain.LanguageCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VocabularyRegistrationDto {
    private VocabularyLearnerDto learner;
    private LanguageCode language;
    private List<VocabularyEntryDto> entries;
}