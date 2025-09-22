package com.lingosphinx.dictionary.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DictionarySearch {
    private Dictionary dictionary;
    private String term;
    private List<DictionaryHeadword> headwords;
}