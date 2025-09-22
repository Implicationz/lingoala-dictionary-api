package com.lingosphinx.dictionary.controller;


import com.lingosphinx.dictionary.dto.DictionaryHeadwordImportDto;
import com.lingosphinx.dictionary.service.DictionaryHeadwordImportService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dictionary-headword-import")
@RequiredArgsConstructor
@Tag(name = "DictionaryHeadwordImport API")
public class DictionaryHeadwordImportController {

    private final DictionaryHeadwordImportService dictionaryHeadwordImportService;

    @PostMapping
    public ResponseEntity<DictionaryHeadwordImportDto> create(@RequestBody @Valid DictionaryHeadwordImportDto dictionaryHeadwordImport) {
        return ResponseEntity.status(HttpStatus.CREATED).body(dictionaryHeadwordImportService.create(dictionaryHeadwordImport));
    }
}