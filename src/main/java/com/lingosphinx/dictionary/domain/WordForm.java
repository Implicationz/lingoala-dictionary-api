package com.lingosphinx.dictionary.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(
        uniqueConstraints = @UniqueConstraint(columnNames = {"lexeme_id", "form_id"})
)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WordForm {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne(optional = false)
    private Lexeme lexeme;
    @ManyToOne(optional = false)
    private Word word;
    @ManyToOne(optional = false)
    private Form form;

}