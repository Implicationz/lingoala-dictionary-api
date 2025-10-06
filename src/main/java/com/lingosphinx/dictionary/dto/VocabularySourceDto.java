package com.lingosphinx.dictionary.dto;

import com.lingosphinx.dictionary.domain.BaseEntity;
import com.lingosphinx.dictionary.domain.LanguageCode;
import com.lingosphinx.dictionary.domain.VocabularyEncounter;
import com.lingosphinx.dictionary.domain.VocabularyLearner;
import jakarta.persistence.Entity;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VocabularySourceDto {

    private Long id;
    private VocabularyLearnerDto learner;
    private String reference;
    private LanguageCode language;
    private String title;
    private List<VocabularyEncounterDto> encounters;
}