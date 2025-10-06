package com.lingosphinx.dictionary.domain;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VocabularyEncounterEvent {
    private VocabularyEncounter encounter;
}