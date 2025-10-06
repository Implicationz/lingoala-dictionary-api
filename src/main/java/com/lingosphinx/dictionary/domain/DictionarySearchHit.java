package com.lingosphinx.dictionary.domain;

import com.lingosphinx.dictionary.repository.DictionarySearchHitProjection;
import lombok.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DictionarySearchHit {

    private DictionarySearch search;
    private DictionaryEntry entry;
    private List<DictionarySearchMatch> matches;

    public static List<DictionarySearchHit> fromProjections(Stream<DictionarySearchHitProjection> projections) {
        var grouped = projections.collect(Collectors.groupingBy(
                DictionarySearchHitProjection::getEntryId,
                LinkedHashMap::new,
                Collectors.toList()
        ));

        return grouped.values().stream().map(collected -> {
            var projection = collected.get(0);
            var headword = DictionaryHeadword.builder()
                    .id(projection.getHeadwordId())
                    .build();
            var entry = DictionaryEntry.builder()
                    .id(projection.getEntryId())
                    .headword(headword)
                    .build();
            var lexeme = Lexeme.builder()
                    .word(Word.builder().notation(projection.getLexemeWordNotation()).build())
                    .partOfSpeech(PartOfSpeech.builder().name(projection.getLexemePartOfSpeechName()).build())
                    .build();
            entry.setLexeme(lexeme);
            var matches = collected.stream().map(DictionarySearchMatch::fromProjection).toList();
            return DictionarySearchHit.builder()
                    .entry(entry)
                    .matches(matches)
                    .build();
        }).toList();
    }


}