package com.lingosphinx.dictionary.repository;

public interface DictionarySearchHitProjection {
    Long getHeadwordId();
    Long getEntryId();
    String getLexemeWordNotation();
    String getLexemePartOfSpeechName();
    String getWordFormWordNotation();
    String getWordFormFormName();
}
