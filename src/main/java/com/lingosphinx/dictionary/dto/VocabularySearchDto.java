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
public class VocabularySearchDto {
    private LanguageCode language;
    private String term;
    private List<VocabularySearchHitDto> hits;
}