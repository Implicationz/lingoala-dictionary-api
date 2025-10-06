package com.lingosphinx.dictionary.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.BatchSize;

import java.util.List;

@Entity
@Table(
        uniqueConstraints = @UniqueConstraint(columnNames = {"learner_id", "language"})
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vocabulary extends BaseEntity {

    @ManyToOne(optional = false)
    private VocabularyLearner learner;
    @Column(nullable = false)
    private LanguageCode language;

    @BatchSize(size = 30)
    @OneToMany(mappedBy = "vocabulary", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<VocabularyEntry> entries;
}