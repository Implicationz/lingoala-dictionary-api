package com.lingosphinx.dictionary.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.BatchSize;

import java.util.List;

@Entity
@Table(
        uniqueConstraints = @UniqueConstraint(columnNames = {"dictionary_id", "title"}),
        indexes = {
            @Index(name = "idx_dictionary_title", columnList = "dictionary_id, title")
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class DictionaryHeadword extends BaseEntity {

    @ManyToOne(optional = false)
    private Dictionary dictionary;

    private String title;
    private String pronunciation;
    private String etymology;

    @BatchSize(size = 30)
    @OneToMany(mappedBy = "headword", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DictionaryEntry> entries;
}