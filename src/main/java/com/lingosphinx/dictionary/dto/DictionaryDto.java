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
public class DictionaryDto {

    private Long id;
    private String name;
    private LanguageCode language;
    private LanguageCode definitionLanguage;
    private List<DictionaryHeadwordDto> headwords;
}