package com.lingosphinx.dictionary.repository;

import com.lingosphinx.dictionary.domain.WordForm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WordFormRepository extends JpaRepository<WordForm, Long> {
}
