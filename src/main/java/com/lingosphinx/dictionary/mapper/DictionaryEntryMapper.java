package com.lingosphinx.dictionary.mapper;

import com.lingosphinx.dictionary.domain.DictionaryEntry;
import com.lingosphinx.dictionary.dto.DictionaryEntryDto;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface DictionaryEntryMapper {
    DictionaryEntryDto toDto(DictionaryEntry dictionaryEntry);
    DictionaryEntry toEntity(DictionaryEntryDto dictionaryEntryDto);
}
