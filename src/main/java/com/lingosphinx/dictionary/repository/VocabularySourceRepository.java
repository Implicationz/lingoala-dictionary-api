package com.lingosphinx.dictionary.repository;

import com.lingosphinx.dictionary.domain.*;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;
import java.util.UUID;

public interface VocabularySourceRepository extends JpaRepository<VocabularySource, Long>, JpaSpecificationExecutor<VocabularySource> {
}
