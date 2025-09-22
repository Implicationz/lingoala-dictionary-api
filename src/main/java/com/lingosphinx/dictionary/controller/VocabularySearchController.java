package com.lingosphinx.dictionary.controller;


import com.lingosphinx.dictionary.dto.VocabularySearchDto;
import com.lingosphinx.dictionary.service.VocabularySearchService;
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
@RequestMapping("/vocabulary-search")
@RequiredArgsConstructor
@Tag(name = "VocabularySearch API")
public class VocabularySearchController {

    private final VocabularySearchService vocabularySearchService;

    @PostMapping
    public ResponseEntity<VocabularySearchDto> search(@RequestBody @Valid VocabularySearchDto vocabularySearch) {
        return ResponseEntity.status(HttpStatus.CREATED).body(vocabularySearchService.search(vocabularySearch));
    }
}