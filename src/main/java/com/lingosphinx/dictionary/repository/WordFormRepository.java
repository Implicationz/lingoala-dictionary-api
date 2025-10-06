package com.lingosphinx.dictionary.repository;

import com.lingosphinx.dictionary.domain.WordForm;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface WordFormRepository extends JpaRepository<WordForm, Long>, JpaSpecificationExecutor<WordForm> {
    @EntityGraph(attributePaths = {"form", "lexeme", "word"})
    @Override
    List<WordForm> findAll(Specification<WordForm> spec);
}

