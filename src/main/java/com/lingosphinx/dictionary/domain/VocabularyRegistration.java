package com.lingosphinx.dictionary.domain;

import lombok.*;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VocabularyRegistration {
    private VocabularyLearner learner;
    private LanguageCode language;
    private List<VocabularyEntry> entries;
}