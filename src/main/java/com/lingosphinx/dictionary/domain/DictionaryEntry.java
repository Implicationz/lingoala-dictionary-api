package com.lingosphinx.dictionary.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.BatchSize;

import java.util.List;

@Entity
@Table(
        uniqueConstraints = @UniqueConstraint(columnNames = {"headword_id", "lexeme_id"})
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class DictionaryEntry extends BaseEntity {

    @ManyToOne(optional = false)
    private DictionaryHeadword headword;

    @ManyToOne(optional = false)
    private Lexeme lexeme;

    @BatchSize(size = 30)
    @OneToMany(mappedBy = "entry", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DictionarySense> senses;
}