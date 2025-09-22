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
        uniqueConstraints = @UniqueConstraint(columnNames = {"dictionary_id", "title"}),
        indexes = {
            @Index(name = "idx_dictionary_title", columnList = "dictionary_id, title")
        }
)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DictionaryHeadword {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne(optional = false)
    private Dictionary dictionary;

    private String title;
    private String pronunciation;
    private String etymology;

    @BatchSize(size = 30)
    @OneToMany(mappedBy = "headword", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DictionaryEntry> entries;
}