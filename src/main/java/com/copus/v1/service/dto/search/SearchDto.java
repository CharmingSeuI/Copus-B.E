package com.copus.v1.service.dto.search;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class SearchDto {
    private String lv1Id;
    private String lv1Title;
    private String author;
    private String originalPublishYear;
    private String lv2Id;
    private String lv2Title;
    private String lv3Id;
    private String lv3Title;
    private String lv4Id;
    private String lv4Title;
    private String content;

    private List<SearchDto> searchDtos;
    public SearchDto(String newLv1Id, String newLv1Title, String newAuthor, String newOriginalPublishYear, String newLv2Id, String newLv2Title, String newLv3Id, String newLv3Title, String newLv4Id, String newLv4Title, String newContent ){
        this.lv1Id = newLv1Id;
        this.lv1Title = newLv1Title;
        this.author = newAuthor;
        this.originalPublishYear = newOriginalPublishYear;
        this.lv2Id = newLv2Id;
        this.lv2Title = newLv2Title;
        this.lv3Id = newLv3Id;
        this.lv3Title = newLv3Title;
        this.lv4Id = newLv4Id;
        this.lv4Title = newLv4Title;
        this.content = newContent;
    }



}
