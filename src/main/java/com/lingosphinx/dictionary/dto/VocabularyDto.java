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
public class VocabularyDto {
    
    private Long id;
    private String title;
    private LanguageCode language;
    private String content;
    private String tokenization;
    private String transliteration;
    private List<VocabularyEntryDto> translations;
}