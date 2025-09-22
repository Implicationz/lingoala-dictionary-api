package com.lingosphinx.dictionary.repository;

import com.lingosphinx.dictionary.domain.PartOfSpeech;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PartOfSpeechRepository extends JpaRepository<PartOfSpeech, Long> {
    Optional<PartOfSpeech> findByName(String name);
}
