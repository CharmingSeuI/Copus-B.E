package com.copus.v1.controller.dto;

import com.copus.v1.service.dto.article.ChapterDto;
import com.copus.v1.service.dto.article.HaejaeDto;
import lombok.Data;

@Data
public class ChapterResponse {
    private String seojiTitle;
    private String chapter;

    public ChapterResponse(ChapterDto chapterDto) {

        this.seojiTitle = chapterDto.getSeojiTitle();
        this.chapter = chapterDto.getChapter();
    }
}
