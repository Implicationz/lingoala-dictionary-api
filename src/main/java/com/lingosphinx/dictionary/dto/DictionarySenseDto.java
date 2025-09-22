package com.lingosphinx.dictionary.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DictionarySenseDto {

    private Long id;
    private DictionaryEntryDto entry;
    private String definition;
    private String examples;
}