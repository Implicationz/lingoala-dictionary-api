package com.lingosphinx.dictionary.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.BatchSize;

import java.util.List;

@Entity
@Table(
        uniqueConstraints = @UniqueConstraint(columnNames = {"word_id", "part_of_speech_id"})
)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Lexeme {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne(optional = false)
    private Word word;

    @ManyToOne(optional = false)
    private PartOfSpeech partOfSpeech;

    @BatchSize(size = 30)
    @OneToMany(mappedBy = "lexeme", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<WordForm> wordForms;
}