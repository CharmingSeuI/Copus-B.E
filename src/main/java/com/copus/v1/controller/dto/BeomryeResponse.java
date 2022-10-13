package com.copus.v1.controller.dto;

import com.copus.v1.service.dto.article.BeomryeDto;
import com.copus.v1.service.dto.article.FinalInfoDto;
import lombok.Data;

@Data
public class BeomryeResponse {
    private String seojiTitle;
    private String beomrye;

    public BeomryeResponse(BeomryeDto beomryeDto) {

        this.seojiTitle = beomryeDto.getSeojiTitle();
        this.beomrye = beomryeDto.getBeomrye();
    }
}
