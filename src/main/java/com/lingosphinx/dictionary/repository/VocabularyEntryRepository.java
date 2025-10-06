package com.lingosphinx.dictionary.repository;

import com.lingosphinx.dictionary.domain.Vocabulary;
import com.lingosphinx.dictionary.domain.VocabularyEntry;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VocabularyEntryRepository extends JpaRepository<VocabularyEntry, Long>, JpaSpecificationExecutor<VocabularyEntry> {
    @EntityGraph(attributePaths = {"lexeme", "lexeme.word", "lexeme.wordForms", "lexeme.wordForms.word", "lexeme.wordForms.form"})
    List<VocabularyEntry> findAllByVocabulary(Vocabulary vocabulary);


    @Query("""
    select 
      e.id as entryId,
      e.proficiency as entryProficiency,
      lw.notation as lexemeWordNotation,
      lp.name as lexemePartOfSpeechName,
      wfw.notation as wordFormWordNotation,
      f.name as wordFormFormName
    from VocabularyEntry e
    join e.lexeme l
    join l.word lw
    join l.partOfSpeech lp
    join l.wordForms wf
    join wf.word wfw
    join wf.form f
    where wfw.notation like concat(:term, '%')
      and e.vocabulary = :vocabulary
    """)
    List<VocabularySearchHitProjection> findSearchHitsByWordForm(Vocabulary vocabulary, String term);
}
