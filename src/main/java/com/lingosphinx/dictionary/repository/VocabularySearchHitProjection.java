package com.lingosphinx.dictionary.repository;

import com.lingosphinx.dictionary.domain.ProficiencyLevel;

public interface VocabularySearchHitProjection {
    Long getEntryId();
    ProficiencyLevel getEntryProficiency();
    String getLexemeWordNotation();
    String getLexemePartOfSpeechName();
    String getWordFormWordNotation();
    String getWordFormFormName();
}
