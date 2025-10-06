package com.lingosphinx.dictionary.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.BatchSize;

import java.util.List;

@Entity
@Table(
        uniqueConstraints = @UniqueConstraint(columnNames = {"learner_id", "reference"})
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VocabularySource extends BaseEntity {
    @ManyToOne(optional = false)
    private VocabularyLearner learner;
    private String reference;
    private LanguageCode language;
    private String title;

    @BatchSize(size = 30)
    @OneToMany(mappedBy = "source", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<VocabularyEncounter> encounters;
}