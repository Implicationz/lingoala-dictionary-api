package com.lingosphinx.dictionary.repository;

import com.lingosphinx.dictionary.domain.Lexeme;
import com.lingosphinx.dictionary.domain.PartOfSpeech;
import com.lingosphinx.dictionary.domain.Word;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LexemeRepository extends JpaRepository<Lexeme, Long> {
    Optional<Lexeme> findByWordAndPartOfSpeech(Word word, PartOfSpeech partOfSpeech);
}
