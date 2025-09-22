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
public class DictionaryHeadwordDto {

    private Long id;
    private DictionaryDto dictionary;
    private String title;
    private String pronunciation;
    private String etymology;
    private List<DictionaryEntryDto> entries;
}