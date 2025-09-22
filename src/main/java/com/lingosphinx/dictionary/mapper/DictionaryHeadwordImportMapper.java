package com.lingosphinx.dictionary.mapper;

import com.lingosphinx.dictionary.domain.Dictionary;
import com.lingosphinx.dictionary.domain.DictionaryEntry;
import com.lingosphinx.dictionary.domain.DictionaryHeadwordImport;
import com.lingosphinx.dictionary.domain.DictionarySense;
import com.lingosphinx.dictionary.dto.DictionaryDto;
import com.lingosphinx.dictionary.dto.DictionaryEntryDto;
import com.lingosphinx.dictionary.dto.DictionaryHeadwordImportDto;
import com.lingosphinx.dictionary.dto.DictionarySenseDto;
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
}
