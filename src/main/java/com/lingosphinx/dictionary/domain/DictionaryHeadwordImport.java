package com.lingosphinx.dictionary.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DictionaryHeadwordImport {
    
    private DictionaryHeadword headword;
}