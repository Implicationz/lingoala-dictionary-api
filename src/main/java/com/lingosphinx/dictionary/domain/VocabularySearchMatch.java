package com.lingosphinx.dictionary.domain;

import com.lingosphinx.dictionary.repository.VocabularySearchHitProjection;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VocabularySearchMatch {
    private WordForm wordForm;

    public static VocabularySearchMatch fromProjection(VocabularySearchHitProjection p) {
        var wordForm = WordForm.builder()
                .word(Word.builder().notation(p.getWordFormWordNotation()).build())
                .form(Form.builder().name(p.getWordFormFormName()).build())
                .build();

        return VocabularySearchMatch
                .builder()
                .wordForm(wordForm)
                .build();
    }
}