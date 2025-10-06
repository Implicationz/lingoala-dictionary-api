package com.lingosphinx.dictionary.repository;

import com.lingosphinx.dictionary.domain.Lexeme;
import com.lingosphinx.dictionary.domain.PartOfSpeech;
import com.lingosphinx.dictionary.domain.Word;
import com.lingosphinx.dictionary.domain.WordForm;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface LexemeRepository extends JpaRepository<Lexeme, Long>, JpaSpecificationExecutor<Lexeme> {
    Optional<Lexeme> findByWordAndPartOfSpeech(Word word, PartOfSpeech partOfSpeech);

    @EntityGraph(attributePaths = {"partOfSpeech", "word"})
    @Override
    List<Lexeme> findAll(Specification<Lexeme> spec);

}
