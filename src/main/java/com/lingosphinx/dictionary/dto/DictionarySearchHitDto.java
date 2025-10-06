package com.lingosphinx.dictionary.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DictionarySearchHitDto {
    private DictionarySearchDto search;
    private DictionaryEntryDto entry;
    private List<DictionarySearchMatchDto> matches;
}