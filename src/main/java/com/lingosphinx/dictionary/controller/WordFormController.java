package com.lingosphinx.dictionary.controller;

import com.lingosphinx.dictionary.dto.WordFormDto;
import com.lingosphinx.dictionary.service.WordFormService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/word-form")
@RequiredArgsConstructor
@Tag(name = "WordForm API")
public class WordFormController {

    private final WordFormService wordFormService;

    @PostMapping
    public ResponseEntity<WordFormDto> create(@RequestBody @Valid WordFormDto wordForm) {
        return ResponseEntity.status(HttpStatus.CREATED).body(wordFormService.create(wordForm));
    }

    @GetMapping("/{id}")
    public ResponseEntity<WordFormDto> readById(@PathVariable Long id) {
        return ResponseEntity.ok(wordFormService.readById(id));
    }

    @GetMapping
    public ResponseEntity<List<WordFormDto>> readAll(
            @RequestParam(required = false) String word,
            @RequestParam(required = false) String lexeme) {
        return ResponseEntity.ok(wordFormService.readAll(word, lexeme));
    }


    @PutMapping("/{id}")
    public ResponseEntity<WordFormDto> update(@PathVariable Long id, @RequestBody @Valid WordFormDto wordForm) {
        return ResponseEntity.ok(wordFormService.update(id, wordForm));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        wordFormService.delete(id);
        return ResponseEntity.noContent().build();
    }
}