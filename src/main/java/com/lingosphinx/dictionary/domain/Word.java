package com.lingosphinx.dictionary.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(
        uniqueConstraints = @UniqueConstraint(columnNames = {"language", "notation"})
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Word extends BaseEntity {

    private LanguageCode language;
    private String notation;

}