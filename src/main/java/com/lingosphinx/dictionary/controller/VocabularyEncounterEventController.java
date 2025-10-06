package com.lingosphinx.dictionary.controller;


import com.lingosphinx.dictionary.dto.VocabularyEncounterEventDto;
import com.lingosphinx.dictionary.service.VocabularyEncounterService;
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
@RequestMapping("/vocabulary-encounter-event")
@RequiredArgsConstructor
@Tag(name = "VocabularyEncounterEvent API")
public class VocabularyEncounterEventController {

    private final VocabularyEncounterService vocabularyEncounterService;

    @PostMapping
    public ResponseEntity<VocabularyEncounterEventDto> registration(@RequestBody @Valid VocabularyEncounterEventDto vocabularyEncounterEvent) {
        return ResponseEntity.status(HttpStatus.CREATED).body(vocabularyEncounterService.handle(vocabularyEncounterEvent));
    }
}