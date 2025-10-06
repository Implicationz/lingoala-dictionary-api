package com.lingosphinx.dictionary.repository;

import com.lingosphinx.dictionary.domain.LanguageCode;
import com.lingosphinx.dictionary.domain.VocabularySource;
import com.lingosphinx.dictionary.domain.VocabularyLearner;
import org.springframework.data.jpa.domain.Specification;

public class VocabularySourceSpecifications {

    public static Specification<VocabularySource> learnerEquals(VocabularyLearner learner) {
        return (root, query, cb) -> cb.equal(root.get("learner"), learner);
    }

    public static Specification<VocabularySource> titleFuzzy(String title) {
        return (root, query, cb) -> cb.like(cb.lower(root.get("title")), "%" + title.toLowerCase() + "%");
    }

    public static Specification<VocabularySource> languageEquals(LanguageCode language) {
        return (root, query, cb) -> cb.equal(root.get("language"), language);
    }
}
