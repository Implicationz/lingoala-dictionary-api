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
public class VocabularySearchDto {
    private String term;
    private List<VocabularyEntryDto> entries;
}