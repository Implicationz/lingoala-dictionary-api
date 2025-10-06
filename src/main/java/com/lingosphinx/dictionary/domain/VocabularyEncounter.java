package com.lingosphinx.dictionary.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VocabularyEncounter extends BaseEntity {

    @ManyToOne(optional = false)
    private VocabularyEntry entry;
    @ManyToOne(optional = false)
    private WordForm wordForm;
    private String text;
}