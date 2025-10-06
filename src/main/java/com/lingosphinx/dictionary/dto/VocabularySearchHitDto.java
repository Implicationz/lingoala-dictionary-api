package com.lingosphinx.dictionary.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VocabularySearchHitDto {
    private VocabularyEntryDto entry;
    private List<VocabularySearchMatchDto> matches;
}