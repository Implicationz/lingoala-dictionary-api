package com.lingosphinx.dictionary.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DictionaryHeadwordImportDto {

    private DictionaryHeadwordDto headword;
}