package com.lingosphinx.dictionary.service;

import com.lingosphinx.dictionary.dto.VocabularyEncounterDto;
import com.lingosphinx.dictionary.dto.VocabularyEncounterEventDto;

import java.util.List;

public interface VocabularyEncounterService {
    VocabularyEncounterDto create(VocabularyEncounterDto vocabularyEncounter);
    VocabularyEncounterDto readById(Long id);
    List<VocabularyEncounterDto> readAll();
    VocabularyEncounterDto update(Long id, VocabularyEncounterDto vocabularyEncounter);
    void delete(Long id);

    VocabularyEncounterEventDto handle(VocabularyEncounterEventDto vocabularyEncounterEvent);
}
