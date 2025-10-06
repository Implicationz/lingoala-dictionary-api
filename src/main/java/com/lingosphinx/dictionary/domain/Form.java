package com.lingosphinx.dictionary.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Form extends BaseEntity {

    @Column(unique = true)
    private String name;
}