package com.lingosphinx.dictionary.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VocabularyMeaning extends BaseEntity {

    @ManyToOne(optional = false)
    private VocabularyEntry entry;
    private String definition;
}