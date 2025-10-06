package com.lingosphinx.dictionary.controller;

import com.lingosphinx.dictionary.dto.LexemeDto;
import com.lingosphinx.dictionary.service.LexemeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lexeme")
@RequiredArgsConstructor
@Tag(name = "Lexeme API")
public class LexemeController {

    private final LexemeService lexemeService;

    @PostMapping
    public ResponseEntity<LexemeDto> create(@RequestBody @Valid LexemeDto lexeme) {
        return ResponseEntity.status(HttpStatus.CREATED).body(lexemeService.create(lexeme));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LexemeDto> readById(@PathVariable Long id) {
        return ResponseEntity.ok(lexemeService.readById(id));
    }

    @GetMapping
    public ResponseEntity<List<LexemeDto>> readAll(
            @RequestParam(required = false) String word) {
        return ResponseEntity.ok(lexemeService.readAll(word));
    }


    @PutMapping("/{id}")
    public ResponseEntity<LexemeDto> update(@PathVariable Long id, @RequestBody @Valid LexemeDto lexeme) {
        return ResponseEntity.ok(lexemeService.update(id, lexeme));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        lexemeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}