package com.lingosphinx.dictionary.repository;

import com.lingosphinx.dictionary.domain.Vocabulary;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VocabularyRepository extends JpaRepository<Vocabulary, Long> {
    @EntityGraph(attributePaths = {"translations"})
    @Override
    Optional<Vocabulary> findById(Long id);
}
