package com.copus.v1.controller.dto;

import com.copus.v1.service.serviceDto.articleDto.showDto.FinalDataDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FinalData {
    private String title;
    private String annotation;
    private String content;

    public FinalData(FinalDataDto finalData) {
        title = finalData.getFinalInfoTitle();
        content = finalData.getContent();
    }
}