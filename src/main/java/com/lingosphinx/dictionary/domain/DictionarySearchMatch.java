package com.lingosphinx.dictionary.domain;

import com.lingosphinx.dictionary.repository.DictionarySearchHitProjection;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DictionarySearchMatch {

    private DictionarySearchHit hit;
    private WordForm wordForm;

    public static DictionarySearchMatch fromProjection(DictionarySearchHitProjection p) {
        var wordForm = WordForm.builder()
                .word(Word.builder().notation(p.getWordFormWordNotation()).build())
                .form(Form.builder().name(p.getWordFormFormName()).build())
                .build();

        return DictionarySearchMatch
                .builder()
                .wordForm(wordForm)
                .build();
    }
}