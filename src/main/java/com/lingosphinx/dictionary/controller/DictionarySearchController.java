package com.lingosphinx.dictionary.controller;


import com.lingosphinx.dictionary.dto.DictionarySearchDto;
import com.lingosphinx.dictionary.service.DictionarySearchService;
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
@RequestMapping("/dictionary-search")
@RequiredArgsConstructor
@Tag(name = "DictionarySearch API")
public class DictionarySearchController {

    private final DictionarySearchService dictionarySearchService;

    @PostMapping
    public ResponseEntity<DictionarySearchDto> search(@RequestBody @Valid DictionarySearchDto dictionarySearch) {
        return ResponseEntity.status(HttpStatus.CREATED).body(dictionarySearchService.search(dictionarySearch));
    }
}