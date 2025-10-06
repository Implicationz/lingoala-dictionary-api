package com.lingosphinx.dictionary.repository;
import org.springframework.data.jpa.domain.Specification;
import com.lingosphinx.dictionary.domain.Lexeme;

public class LexemeSpecifications {
    public static Specification<Lexeme> wordNotationFuzzy(String word) {
        return (root, query, cb) -> cb.like(cb.lower(root.get("word").get("notation")), word.toLowerCase() + "%");
    }
}
