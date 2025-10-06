package com.lingosphinx.dictionary.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DictionarySense extends BaseEntity {

    @ManyToOne(optional = false)
    private DictionaryEntry entry;

    private String definition;
    private String examples;
}