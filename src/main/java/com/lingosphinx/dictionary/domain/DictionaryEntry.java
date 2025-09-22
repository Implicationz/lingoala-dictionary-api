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
        uniqueConstraints = @UniqueConstraint(columnNames = {"headword_id", "lexeme_id"})
)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DictionaryEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne(optional = false)
    private DictionaryHeadword headword;

    @ManyToOne(optional = false)
    private Lexeme lexeme;

    @BatchSize(size = 30)
    @OneToMany(mappedBy = "entry", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DictionarySense> senses;
}