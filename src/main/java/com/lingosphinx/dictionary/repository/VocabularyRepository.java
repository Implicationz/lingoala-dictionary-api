package com.lingosphinx.dictionary.repository;

import com.lingosphinx.dictionary.domain.LanguageCode;
import com.lingosphinx.dictionary.domain.Vocabulary;
import com.lingosphinx.dictionary.domain.VocabularyLearner;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface VocabularyRepository extends JpaRepository<Vocabulary, Long> {
    @EntityGraph(attributePaths = {"entries"})
    @Override
    Optional<Vocabulary> findById(Long id);

    Optional<Vocabulary> findByLearnerAndLanguage(VocabularyLearner vocabularyLearner, LanguageCode language);
    Optional<Vocabulary> findByLearner_UserIdAndLanguage(UUID userId, LanguageCode language);
}
