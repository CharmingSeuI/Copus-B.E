package com.copus.v1.controller.dto;

import com.copus.v1.service.dto.article.HaejaeDto;
import lombok.Data;

@Data
public class HaejaeResponse {
    private String seojiTitle;
    private String haejae;

    public HaejaeResponse(HaejaeDto haejaeDto) {

        this.seojiTitle = haejaeDto.getSeojiTitle();
        this.haejae = haejaeDto.getHaejae();
    }
}
