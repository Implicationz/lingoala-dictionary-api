package com.lingosphinx.dictionary.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.BatchSize;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class VocabularyEntry extends BaseEntity {

    @ManyToOne(optional = false)
    private Vocabulary vocabulary;
    @ManyToOne(optional = false)
    private Lexeme lexeme;

    @Enumerated(EnumType.STRING)
    private ProficiencyLevel proficiency;

    @BatchSize(size = 30)
    @OneToMany(mappedBy = "entry", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<VocabularyEncounter> encounters;

    @BatchSize(size = 30)
    @OneToMany(mappedBy = "entry", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<VocabularyMeaning> meanings;
}