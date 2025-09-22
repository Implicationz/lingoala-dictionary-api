package com.lingosphinx.dictionary.repository;

import com.lingosphinx.dictionary.domain.Dictionary;
import com.lingosphinx.dictionary.domain.DictionaryHeadword;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface DictionaryHeadwordRepository extends JpaRepository<DictionaryHeadword, Long>, JpaSpecificationExecutor<DictionaryHeadword> {
    @EntityGraph(attributePaths = {"dictionary", "entries", "entries.lexeme"})
    @Override
    Optional<DictionaryHeadword> findById(Long id);

    Optional<DictionaryHeadword> findByDictionaryAndTitle(Dictionary dictionary, String title);
}
