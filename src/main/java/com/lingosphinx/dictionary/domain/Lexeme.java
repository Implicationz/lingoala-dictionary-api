package com.lingosphinx.dictionary.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.BatchSize;

import java.util.List;

@Entity
@Table(
        uniqueConstraints = @UniqueConstraint(columnNames = {"word_id", "part_of_speech_id"})
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Lexeme extends BaseEntity {

    @ManyToOne(optional = false)
    private Word word;

    @ManyToOne(optional = false)
    private PartOfSpeech partOfSpeech;

    @BatchSize(size = 30)
    @OneToMany(mappedBy = "lexeme", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<WordForm> wordForms;
}