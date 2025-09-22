package com.lingosphinx.dictionary.dto;

import com.lingosphinx.dictionary.domain.LanguageCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VocabularyEntryDto {

    private Long id;
    private VocabularyDto vocabulary;
    private LanguageCode language;
    private String token;
}