package com.lingosphinx.dictionary.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WordOccurrence extends BaseEntity {

    @ManyToOne(optional = false)
    private Word word;

}