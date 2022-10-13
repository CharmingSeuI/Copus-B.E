package com.copus.v1.controller.dto;

import com.copus.v1.service.dto.article.SeojiInfoDataDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SeojiData {
    private String seojiId;
    private String seojiTitle;
    private String authorName;
    private String zipsu;
    private String publishYear;

    public SeojiData(SeojiInfoDataDto data) {
        this.seojiId = data.getSeojiId();
        this.seojiTitle = data.getSeojiTitle();
        this.authorName = data.getAuthorName();
        this.zipsu = data.getZipsu();
        this.publishYear = data.getPublishYear();
    }
}

