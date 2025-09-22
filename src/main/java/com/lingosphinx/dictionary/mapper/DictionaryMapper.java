package com.lingosphinx.dictionary.mapper;

import com.lingosphinx.dictionary.domain.Dictionary;
import com.lingosphinx.dictionary.domain.DictionaryHeadword;
import com.lingosphinx.dictionary.dto.DictionaryDto;
import com.lingosphinx.dictionary.dto.DictionaryHeadwordDto;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface DictionaryMapper {
    DictionaryDto toDto(Dictionary dictionary);
    Dictionary toEntity(DictionaryDto dictionaryDto);

    @Mapping(target = "dictionary", ignore = true)
    @Mapping(target = "entries", ignore = true)
    DictionaryHeadwordDto toDto(DictionaryHeadword dictionaryHeadword);
    @Mapping(target = "dictionary", ignore = true)
    @Mapping(target = "entries", ignore = true)
    DictionaryHeadword toEntity(DictionaryHeadwordDto dictionaryHeadwordDto);

    void updateEntityFromDto(DictionaryDto dictionaryDto, @MappingTarget Dictionary existingDictionary);
    void updateEntityFromDto(DictionaryHeadwordDto dictionaryHeadwordDto, @MappingTarget DictionaryHeadword existingDictionaryHeadword);
}
