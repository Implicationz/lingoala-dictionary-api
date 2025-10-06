package com.lingosphinx.dictionary.mapper;

import com.lingosphinx.dictionary.domain.Lexeme;
import com.lingosphinx.dictionary.domain.WordForm;
import com.lingosphinx.dictionary.dto.LexemeDto;
import com.lingosphinx.dictionary.dto.WordFormDto;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface WordFormMapper {
    WordFormDto toDto(WordForm wordForm);
    WordForm toEntity(WordFormDto wordFormDto);

    @Mapping(target = "wordForms", ignore = true)
    LexemeDto toDto(Lexeme lexeme);
    @Mapping(target = "wordForms", ignore = true)
    Lexeme toEntity(LexemeDto lexemeDto);

    void updateEntityFromDto(WordFormDto wordFormDto, @MappingTarget WordForm wordForm);

    List<WordFormDto> toDtoList(List<WordForm> wordForms);
}
