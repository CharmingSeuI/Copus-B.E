package com.copus.v1.controller.dto;

import com.copus.v1.service.serviceDto.articleDto.showDto.FinalInfoDto;
import lombok.Data;

@Data
public class FinalResponse {
    private String seojiId;
    private String seojiTitle;
    private String gwonchaId;
    private String gwonchaTitle;
    private String muncheId;
    private String muncheTitle;
    private FinalData finalData;

    public FinalResponse(FinalInfoDto finalInfo) {
        this.seojiId = finalInfo.getSeojiId();
        this.seojiTitle = finalInfo.getSeojiTitle();
        this.gwonchaId = finalInfo.getGwonchaId();
        this.gwonchaTitle = finalInfo.getGwonchaTitle();
        this.muncheId = finalInfo.getMuncheId();
        this.muncheTitle = finalInfo.getMuncheTitle();
        finalData = new FinalData(finalInfo.getFinalData());
    }
}
