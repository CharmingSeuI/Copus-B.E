package com.copus.v1.controller.dto;

import com.copus.v1.service.dto.article.DatasDto;
import com.copus.v1.service.dto.article.GwonchaInfoDto;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class GwonchaResponse {
    private String seojiId;
    private String seojiTitle;
    private List<GwonchaPreview> datas = new ArrayList<>();

    public GwonchaResponse(GwonchaInfoDto gwonchaInfo) {
        seojiId = gwonchaInfo.getSeojiId();
        seojiTitle = gwonchaInfo.getSeojiTitle();
        for (DatasDto data : gwonchaInfo.getDatas()) {
            datas.add(new GwonchaPreview(data));
        }
    }
}