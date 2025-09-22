package com.lingosphinx.dictionary.controller;


import com.lingosphinx.dictionary.dto.VocabularyEntryDto;
import com.lingosphinx.dictionary.service.VocabularyEntryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vocabulary-entry")
@RequiredArgsConstructor
@Tag(name = "VocabularyEntry API")
public class VocabularyEntryController {

    private final VocabularyEntryService vocabularyEntryService;

    @PostMapping
    public ResponseEntity<VocabularyEntryDto> create(@RequestBody @Valid VocabularyEntryDto vocabularyEntry) {
        return ResponseEntity.status(HttpStatus.CREATED).body(vocabularyEntryService.create(vocabularyEntry));
    }

    @GetMapping("/{id}")
    public ResponseEntity<VocabularyEntryDto> readById(@PathVariable Long id) {
        return ResponseEntity.ok(vocabularyEntryService.readById(id));
    }

    @GetMapping
    public ResponseEntity<List<VocabularyEntryDto>> readAll() {
        return ResponseEntity.ok(vocabularyEntryService.readAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<VocabularyEntryDto> update(@PathVariable Long id, @RequestBody @Valid VocabularyEntryDto vocabularyEntry) {
        return ResponseEntity.ok(vocabularyEntryService.update(id, vocabularyEntry));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        vocabularyEntryService.delete(id);
        return ResponseEntity.noContent().build();
    }
}