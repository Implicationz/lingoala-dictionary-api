package com.lingosphinx.dictionary.repository;

import com.lingosphinx.dictionary.domain.WordForm;
import org.springframework.data.jpa.domain.Specification;

public class WordFormSpecifications {
    public static Specification<WordForm> wordNotationFuzzy(String word) {
        return (root, query, cb) -> cb.like(cb.lower(root.get("word").get("notation")), word.toLowerCase() + "%");
    }

    public static Specification<WordForm> lexemeNotationEquals(String lexeme) {
        return (root, query, cb) -> cb.equal(root.get("lexeme").get("word").get("notation"), lexeme);
    }
}
