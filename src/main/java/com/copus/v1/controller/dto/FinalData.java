package com.copus.v1.controller.dto;

import com.copus.v1.service.dto.article.FinalDataDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FinalData {
    private String title;
    private String content;
    private String DCI;
    private String annotations;


    public FinalData(FinalDataDto finalData) {
        title = finalData.getFinalInfoTitle();
        content = finalData.getContent();
        DCI = finalData.getDCI();
        annotations = String.valueOf(finalData.getAnnotations());
    }
}