package com.copus.v1.controller.dto;

import com.copus.v1.service.dto.article.FinalsDto;
import com.copus.v1.service.dto.article.MuncheInfoDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MuncheResponse {
    private String seojiId;
    private String seojiTitle;
    private String gwonchaId;
    private String gwonchaTitle;
    private String muncheTitle;
    private List<FinalPreview> datas = new ArrayList<>();

    public MuncheResponse(MuncheInfoDto muncheInfo) {
        this.seojiId = muncheInfo.getSeojiId();
        this.seojiTitle = muncheInfo.getSeojiTitle();
        this.gwonchaId = muncheInfo.getGwonchaId();
        this.gwonchaTitle = muncheInfo.getGwonchaTitle();
        this.muncheTitle = muncheInfo.getMuncheTitle();
        for (FinalsDto finalDto : muncheInfo.getFinals()) {
            datas.add(new FinalPreview(finalDto));
        }
    }
}