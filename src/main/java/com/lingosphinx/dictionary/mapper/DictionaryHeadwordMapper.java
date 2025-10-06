package com.lingosphinx.dictionary.mapper;

import com.lingosphinx.dictionary.domain.*;
import com.lingosphinx.dictionary.dto.*;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface DictionaryHeadwordMapper {
    DictionaryHeadwordDto toDto(DictionaryHeadword dictionaryHeadword);
    DictionaryHeadword toEntity(DictionaryHeadwordDto dictionaryHeadwordDto);

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

    void updateEntityFromDto(DictionaryHeadwordDto dictionaryHeadwordDto, @MappingTarget DictionaryHeadword existingDictionaryHeadword);
    void updateEntityFromDto(DictionaryEntryDto dictionaryEntryDto, @MappingTarget DictionaryEntry existingDictionaryEntry);
}
