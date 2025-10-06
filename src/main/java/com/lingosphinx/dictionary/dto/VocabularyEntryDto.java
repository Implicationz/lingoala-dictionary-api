package com.lingosphinx.dictionary.dto;

import com.lingosphinx.dictionary.domain.ProficiencyLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VocabularyEntryDto {

    private Long id;
    private VocabularyDto vocabulary;
    private LexemeDto lexeme;
    private ProficiencyLevel proficiency;
    private List<VocabularyEncounterDto> encounters;
}