package com.lingosphinx.dictionary.repository;

import com.lingosphinx.dictionary.domain.VocabularyLearner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface VocabularyLearnerRepository extends JpaRepository<VocabularyLearner, Long> {
    Optional<VocabularyLearner> findByUserId(UUID userId);
}
