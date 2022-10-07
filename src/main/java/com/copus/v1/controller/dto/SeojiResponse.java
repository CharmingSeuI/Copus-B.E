package com.copus.v1.controller.dto;

import com.copus.v1.service.dto.article.SeojiInfoDataDto;
import com.copus.v1.service.dto.article.SeojiInfoDto;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class SeojiResponse {
    private int count;
    private List<SeojiData> datas = new ArrayList<>();


    public SeojiResponse(SeojiInfoDto seojiDto) {
        count = seojiDto.getCount();
        for (SeojiInfoDataDto data : seojiDto.getData()) {
            datas.add(new SeojiData(data));
        }
    }
}

