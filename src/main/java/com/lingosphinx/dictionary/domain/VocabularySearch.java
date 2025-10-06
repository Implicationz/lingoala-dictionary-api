package com.lingosphinx.dictionary.domain;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VocabularySearch {
    private LanguageCode language;
    private String term;
    private List<VocabularySearchHit> hits;
}