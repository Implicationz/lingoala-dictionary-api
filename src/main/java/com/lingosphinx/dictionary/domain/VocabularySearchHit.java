package com.lingosphinx.dictionary.domain;

import com.lingosphinx.dictionary.repository.VocabularySearchHitProjection;
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
public class VocabularySearchHit {
    private VocabularyEntry entry;
    private List<VocabularySearchMatch> matches;


    public static List<VocabularySearchHit> fromProjections(Stream<VocabularySearchHitProjection> projections) {
        var grouped = projections.collect(Collectors.groupingBy(
                VocabularySearchHitProjection::getEntryId,
                LinkedHashMap::new,
                Collectors.toList()
        ));

        return grouped.values().stream().map(collected -> {
            var projection = collected.get(0);
            var lexeme = Lexeme.builder()
                    .word(Word.builder().notation(projection.getLexemeWordNotation()).build())
                    .partOfSpeech(PartOfSpeech.builder().name(projection.getLexemePartOfSpeechName()).build())
                    .build();

            var entry = VocabularyEntry.builder()
                    .id(projection.getEntryId())
                    .lexeme(lexeme)
                    .build();
            var matches = collected.stream().map(VocabularySearchMatch::fromProjection).toList();
            return VocabularySearchHit.builder()
                    .entry(entry)
                    .matches(matches)
                    .build();
        }).toList();
    }
}