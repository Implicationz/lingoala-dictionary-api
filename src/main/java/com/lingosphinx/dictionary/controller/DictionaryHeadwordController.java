package com.lingosphinx.dictionary.controller;


import com.lingosphinx.dictionary.dto.DictionaryHeadwordDto;
import com.lingosphinx.dictionary.service.DictionaryHeadwordService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dictionary-headword")
@RequiredArgsConstructor
@Tag(name = "DictionaryHeadword API")
public class DictionaryHeadwordController {

    private final DictionaryHeadwordService dictionaryHeadwordService;

    @PostMapping
    public ResponseEntity<DictionaryHeadwordDto> create(@RequestBody @Valid DictionaryHeadwordDto dictionaryHeadword) {
        return ResponseEntity.status(HttpStatus.CREATED).body(dictionaryHeadwordService.create(dictionaryHeadword));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DictionaryHeadwordDto> readById(@PathVariable Long id) {
        return ResponseEntity.ok(dictionaryHeadwordService.readById(id));
    }

    @GetMapping
    public ResponseEntity<List<DictionaryHeadwordDto>> readAll() {
        return ResponseEntity.ok(dictionaryHeadwordService.readAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<DictionaryHeadwordDto> update(@PathVariable Long id, @RequestBody @Valid DictionaryHeadwordDto dictionaryHeadword) {
        return ResponseEntity.ok(dictionaryHeadwordService.update(id, dictionaryHeadword));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        dictionaryHeadwordService.delete(id);
        return ResponseEntity.noContent().build();
    }
}