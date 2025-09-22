package com.lingosphinx.dictionary.repository;

import com.lingosphinx.dictionary.domain.LanguageCode;
import com.lingosphinx.dictionary.domain.Word;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WordRepository extends JpaRepository<Word, Long> {
    Optional<Word> findByLanguageAndNotation(LanguageCode language, String notation);
}
