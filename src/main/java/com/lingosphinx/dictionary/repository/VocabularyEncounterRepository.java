package com.lingosphinx.dictionary.repository;

import com.lingosphinx.dictionary.domain.VocabularyEncounter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface VocabularyEncounterRepository extends JpaRepository<VocabularyEncounter, Long>, JpaSpecificationExecutor<VocabularyEncounter> {
}
