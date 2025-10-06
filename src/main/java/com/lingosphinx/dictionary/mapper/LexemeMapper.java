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
public interface LexemeMapper {
    LexemeDto toDto(Lexeme lexeme);
    Lexeme toEntity(LexemeDto lexemeDto);

    @Mapping(target = "lexeme", ignore = true)
    WordFormDto toDto(WordForm wordForm);
    @Mapping(target = "lexeme", ignore = true)
    WordForm toEntity(WordFormDto wordFormDto);

    @Mapping(target = "wordForms", ignore = true)
    void updateEntityFromDto(LexemeDto lexemeDto, @MappingTarget Lexeme lexeme);

    @Mapping(target = "lexeme", ignore = true)
    void updateEntityFromDto(WordFormDto wordFormDto, @MappingTarget WordForm wordForm);

    default List<LexemeDto> toDtoList(List<Lexeme> lexemes) {
        return lexemes.stream()
                .map(this::toDtoList)
                .toList();
    }

    @Mapping(target = "wordForms", ignore = true)
    LexemeDto toDtoList(Lexeme lexeme);
}
