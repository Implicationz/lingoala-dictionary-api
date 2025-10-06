package com.lingosphinx.dictionary.controller;


import com.lingosphinx.dictionary.dto.VocabularyRegistrationDto;
import com.lingosphinx.dictionary.service.VocabularyRegistrationService;
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
@RequestMapping("/vocabulary-registration")
@RequiredArgsConstructor
@Tag(name = "VocabularyRegistration API")
public class VocabularyRegistrationController {

    private final VocabularyRegistrationService vocabularyRegistrationService;

    @PostMapping
    public ResponseEntity<VocabularyRegistrationDto> registration(@RequestBody @Valid VocabularyRegistrationDto vocabularyRegistration) {
        return ResponseEntity.status(HttpStatus.CREATED).body(vocabularyRegistrationService.register(vocabularyRegistration));
    }
}