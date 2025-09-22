package com.lingosphinx.dictionary.controller;


import com.lingosphinx.dictionary.dto.DictionaryDto;
import com.lingosphinx.dictionary.service.DictionaryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dictionary")
@RequiredArgsConstructor
@Tag(name = "Dictionary API")
public class DictionaryController {

    private final DictionaryService dictionaryService;

    @PostMapping
    public ResponseEntity<DictionaryDto> create(@RequestBody @Valid DictionaryDto dictionary) {
        return ResponseEntity.status(HttpStatus.CREATED).body(dictionaryService.create(dictionary));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DictionaryDto> readById(@PathVariable Long id) {
        return ResponseEntity.ok(dictionaryService.readById(id));
    }

    @GetMapping
    public ResponseEntity<List<DictionaryDto>> readAll() {
        return ResponseEntity.ok(dictionaryService.readAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<DictionaryDto> update(@PathVariable Long id, @RequestBody @Valid DictionaryDto dictionary) {
        return ResponseEntity.ok(dictionaryService.update(id, dictionary));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        dictionaryService.delete(id);
        return ResponseEntity.noContent().build();
    }
}