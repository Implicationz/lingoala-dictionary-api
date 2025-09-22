package com.lingosphinx.dictionary.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WordFormDto {

    private Long id;
    private LexemeDto lexeme;
    private WordDto word;
    private FormDto form;

}