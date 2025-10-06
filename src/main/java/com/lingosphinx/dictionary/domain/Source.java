package com.lingosphinx.dictionary.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Source extends BaseEntity {

    @ManyToOne(optional = false)
    private Vocabulary vocabulary;
    private LanguageCode language;
    private String token;
}