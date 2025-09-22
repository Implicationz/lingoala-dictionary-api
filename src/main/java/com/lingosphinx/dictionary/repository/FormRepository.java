package com.lingosphinx.dictionary.repository;

import com.lingosphinx.dictionary.domain.Form;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FormRepository extends JpaRepository<Form, Long> {
    Optional<Form> findByName(String name);
}
