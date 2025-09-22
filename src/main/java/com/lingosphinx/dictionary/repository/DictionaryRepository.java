package com.lingosphinx.dictionary.repository;

import com.lingosphinx.dictionary.domain.Dictionary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DictionaryRepository extends JpaRepository<Dictionary, Long> {
    Optional<Dictionary> findByName(String name);
}
