package com.lingosphinx.dictionary.repository;

import com.lingosphinx.dictionary.domain.DictionaryEntry;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DictionaryEntryRepository extends JpaRepository<DictionaryEntry, Long> {
    @EntityGraph(attributePaths = {"lexeme", "lexeme.wordForms"})
    @Override
    Optional<DictionaryEntry> findById(Long id);
}
