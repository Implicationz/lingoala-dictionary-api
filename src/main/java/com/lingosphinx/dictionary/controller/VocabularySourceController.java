package com.lingosphinx.dictionary.controller;


import com.lingosphinx.dictionary.domain.LanguageCode;
import com.lingosphinx.dictionary.dto.VocabularySourceDto;
import com.lingosphinx.dictionary.service.VocabularySourceService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vocabulary-source")
@RequiredArgsConstructor
@Tag(name = "VocabularySource API")
public class VocabularySourceController {

    private final VocabularySourceService vocabularySourceService;

    @PostMapping
    public ResponseEntity<VocabularySourceDto> create(@RequestBody @Valid VocabularySourceDto vocabularySource) {
        return ResponseEntity.status(HttpStatus.CREATED).body(vocabularySourceService.create(vocabularySource));
    }

    @GetMapping("/{id}")
    public ResponseEntity<VocabularySourceDto> readById(@PathVariable Long id) {
        return ResponseEntity.ok(vocabularySourceService.readById(id));
    }

    @GetMapping
    public ResponseEntity<List<VocabularySourceDto>> readAll(@RequestParam(required = false) String language,
                                                             @RequestParam(required = false) String title) {
        var languageCode = language != null ? LanguageCode.valueOf(language) : null;
        return ResponseEntity.ok(vocabularySourceService.readAll(languageCode, title));
    }

    @PutMapping("/{id}")
    public ResponseEntity<VocabularySourceDto> update(@PathVariable Long id, @RequestBody @Valid VocabularySourceDto vocabularySource) {
        return ResponseEntity.ok(vocabularySourceService.update(id, vocabularySource));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        vocabularySourceService.delete(id);
        return ResponseEntity.noContent().build();
    }
}