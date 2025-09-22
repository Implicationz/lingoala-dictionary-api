package com.lingosphinx.dictionary.dto;

import com.lingosphinx.dictionary.domain.Vocabulary;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.BatchSize;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VocabularyLearnerDto {

    private Long id;
    private UUID user;
    private List<VocabularyDto> vocabularies;
}