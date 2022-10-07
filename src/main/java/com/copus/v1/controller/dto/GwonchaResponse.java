package com.copus.v1.controller.dto;

import com.copus.v1.service.serviceDto.articleDto.showDto.DatasDto;
import com.copus.v1.service.serviceDto.articleDto.showDto.GwonchaInfoDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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