package com.lingosphinx.dictionary.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VocabularyEncounterDto {
    private Long id;
    private VocabularyEntryDto entry;
    private WordFormDto wordForm;
    private String text;
}