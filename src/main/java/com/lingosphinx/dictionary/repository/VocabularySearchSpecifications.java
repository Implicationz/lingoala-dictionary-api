package com.lingosphinx.dictionary.repository;

import com.lingosphinx.dictionary.domain.VocabularyEntry;
import com.lingosphinx.dictionary.domain.VocabularyLearner;
import org.springframework.data.jpa.domain.Specification;

public class VocabularySearchSpecifications {

    public static Specification<VocabularyEntry> fuzzyLexemeAndLearner(String term, VocabularyLearner learner) {
        return (root, query, cb) -> cb.and(
                cb.like(cb.lower(root.get("title")), "%" + term.toLowerCase() + "%"),
                cb.equal(root.get("learner"), learner)
        );
    }
}
