package com.lingosphinx.dictionary.repository;

import com.lingosphinx.dictionary.domain.Dictionary;
import com.lingosphinx.dictionary.domain.DictionaryHeadword;
import org.springframework.data.jpa.domain.Specification;

public class DictionarySearchSpecifications {

    public static Specification<DictionaryHeadword> fuzzyTitleAndDictionary(String term, Dictionary dictionary) {
        return (root, query, cb) -> cb.and(
                cb.like(cb.lower(root.get("title")), "%" + term.toLowerCase() + "%"),
                cb.equal(root.get("dictionary"), dictionary)
        );
    }
}
