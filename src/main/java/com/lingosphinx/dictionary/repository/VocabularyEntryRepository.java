package com.lingosphinx.dictionary.repository;

import com.lingosphinx.dictionary.domain.VocabularyEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface VocabularyEntryRepository extends JpaRepository<VocabularyEntry, Long>, JpaSpecificationExecutor<VocabularyEntry> {
}
