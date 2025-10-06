package com.lingosphinx.dictionary.repository;

import com.lingosphinx.dictionary.domain.Dictionary;
import com.lingosphinx.dictionary.domain.DictionaryEntry;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface DictionaryEntryRepository extends JpaRepository<DictionaryEntry, Long> {
    @EntityGraph(attributePaths = {"lexeme", "lexeme.wordForms"})
    @Override
    Optional<DictionaryEntry> findById(Long id);

    @Query("""
    select 
      e.headword.id as headwordId,
      e.id as entryId,
      lw.notation as lexemeWordNotation,
      lp.name as lexemePartOfSpeechName,
      wfw.notation as wordFormWordNotation,
      f.name as wordFormFormName
    from DictionaryEntry e
    join e.lexeme l
    join l.word lw
    join l.partOfSpeech lp
    join l.wordForms wf
    join wf.word wfw
    join wf.form f
    where wfw.notation like concat(:term, '%')
      and e.headword.dictionary = :dictionary
    """)
    List<DictionarySearchHitProjection> findSearchHitsByWordForm(Dictionary dictionary, String term);

}
