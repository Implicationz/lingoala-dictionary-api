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
public class DictionaryEntryDto {

    private Long id;
    private DictionaryHeadwordDto headword;
    private LexemeDto lexeme;
    private List<DictionarySenseDto> senses;
}