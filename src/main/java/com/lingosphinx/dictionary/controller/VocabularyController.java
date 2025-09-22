package com.lingosphinx.dictionary.controller;


import com.lingosphinx.dictionary.dto.VocabularyDto;
import com.lingosphinx.dictionary.service.VocabularyService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vocabulary")
@RequiredArgsConstructor
@Tag(name = "Vocabulary API")
public class VocabularyController {

    private final VocabularyService vocabularyService;

    @PostMapping
    public ResponseEntity<VocabularyDto> create(@RequestBody @Valid VocabularyDto vocabulary) {
        return ResponseEntity.status(HttpStatus.CREATED).body(vocabularyService.create(vocabulary));
    }

    @GetMapping("/{id}")
    public ResponseEntity<VocabularyDto> readById(@PathVariable Long id) {
        return ResponseEntity.ok(vocabularyService.readById(id));
    }

    @GetMapping
    public ResponseEntity<List<VocabularyDto>> readAll() {
        return ResponseEntity.ok(vocabularyService.readAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<VocabularyDto> update(@PathVariable Long id, @RequestBody @Valid VocabularyDto vocabulary) {
        return ResponseEntity.ok(vocabularyService.update(id, vocabulary));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        vocabularyService.delete(id);
        return ResponseEntity.noContent().build();
    }
}