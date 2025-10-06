package com.lingosphinx.dictionary.mapper;

import com.lingosphinx.dictionary.domain.*;
import com.lingosphinx.dictionary.dto.*;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface DictionaryHeadwordImportMapper {

    DictionaryHeadwordImportDto toDto(DictionaryHeadwordImport dictionaryHeadwordImport);
    DictionaryHeadwordImport toEntity(DictionaryHeadwordImportDto dictionaryHeadwordImportDto);

    @Mapping(target = "headwords", ignore = true)
    DictionaryDto toDto(Dictionary dictionary);
    @Mapping(target = "headwords", ignore = true)
    Dictionary toEntity(DictionaryDto dictionaryDto);

    @Mapping(target = "headword", ignore = true)
    DictionaryEntryDto toDto(DictionaryEntry dictionaryEntry);
    @Mapping(target = "headword", ignore = true)
    DictionaryEntry toEntity(DictionaryEntryDto dictionaryEntryDto);

    @Mapping(target = "entry", ignore = true)
    DictionarySenseDto toDto(DictionarySense dictionarySense);
    @Mapping(target = "entry", ignore = true)
    DictionarySense toEntity(DictionarySenseDto dictionarySenseDto);

    @Mapping(target = "lexeme", ignore = true)
    WordFormDto toDto(WordForm wordForm);
    @Mapping(target = "lexeme", ignore = true)
    WordForm toEntity(WordFormDto wordFormDto);
}
