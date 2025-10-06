package com.lingosphinx.dictionary.mapper;

import com.lingosphinx.dictionary.domain.Dictionary;
import com.lingosphinx.dictionary.domain.DictionaryEntry;
import com.lingosphinx.dictionary.domain.DictionaryHeadword;
import com.lingosphinx.dictionary.domain.DictionarySearch;
import com.lingosphinx.dictionary.dto.DictionaryDto;
import com.lingosphinx.dictionary.dto.DictionaryEntryDto;
import com.lingosphinx.dictionary.dto.DictionaryHeadwordDto;
import com.lingosphinx.dictionary.dto.DictionarySearchDto;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface DictionarySearchMapper {
    DictionarySearchDto toDto(DictionarySearch dictionarySearch);
    DictionarySearch toEntity(DictionarySearchDto dictionarySearchDto);

    @Mapping(target = "headwords", ignore = true)
    DictionaryDto toDto(Dictionary dictionary);
    @Mapping(target = "headwords", ignore = true)
    Dictionary toEntity(DictionaryDto dictionaryDto);

    @Mapping(target = "dictionary", ignore = true)
    @Mapping(target = "entries", ignore = true)
    DictionaryHeadwordDto toDto(DictionaryHeadword dictionaryHeadword);
    @Mapping(target = "dictionary", ignore = true)
    @Mapping(target = "entries", ignore = true)
    DictionaryHeadword toEntity(DictionaryHeadwordDto dictionaryHeadwordDto);

    @Mapping(target = "senses", ignore = true)
    DictionaryEntryDto toDto(DictionaryEntry dictionaryEntry);
    @Mapping(target = "senses", ignore = true)
    DictionaryEntry toEntity(DictionaryEntryDto dictionaryEntryDto);
}
