package com.lingosphinx.dictionary.domain;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DictionarySearch {
    private Dictionary dictionary;
    private String term;
    private List<DictionarySearchHit> hits;
}