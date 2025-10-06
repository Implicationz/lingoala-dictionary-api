package com.lingosphinx.dictionary.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.BatchSize;

import java.util.List;

@Entity
@Table(
        indexes = {
                @Index(name = "idx_dictionary_name", columnList = "name")
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Dictionary extends BaseEntity {

    @Column(unique = true, nullable = false)
    private String name;
    private LanguageCode language;
    private LanguageCode definitionLanguage;

    @BatchSize(size = 30)
    @OneToMany(mappedBy = "dictionary", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DictionaryHeadword> headwords;
}