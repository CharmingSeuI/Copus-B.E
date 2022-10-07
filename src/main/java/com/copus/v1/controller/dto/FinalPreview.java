package com.copus.v1.controller.dto;


import com.copus.v1.service.serviceDto.articleDto.showDto.FinalsDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FinalPreview {
    private String finalId;
    private String finalTitle;

    public FinalPreview(FinalsDto finalDto) {
        finalId = finalDto.getFinalInfoId();
        finalTitle = finalDto.getFinalInfoTitle();
    }
}