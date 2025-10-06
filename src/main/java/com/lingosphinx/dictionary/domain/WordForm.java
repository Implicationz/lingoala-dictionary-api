package com.lingosphinx.dictionary.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(
        uniqueConstraints = @UniqueConstraint(columnNames = {"lexeme_id", "form_id"})
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WordForm extends BaseEntity {

    @ManyToOne(optional = false)
    private Lexeme lexeme;
    @ManyToOne(optional = false)
    private Word word;
    @ManyToOne(optional = false)
    private Form form;

}