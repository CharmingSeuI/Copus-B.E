package com.copus.v1.controller.dto;

import com.copus.v1.service.serviceDto.articleDto.showDto.DatasDto;
import com.copus.v1.service.serviceDto.articleDto.showDto.MunchesDto;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class GwonchaPreview {
    private String gwonchaId;
    private String gwonchaTitle;
    private List<MunchePreview> munches = new ArrayList<>();

    public GwonchaPreview(DatasDto data) {
        gwonchaId = data.getGwonchaId();
        gwonchaTitle = data.getGwonchaTitle();
        for (MunchesDto munche : data.getMunches()) {
            munches.add(new MunchePreview(munche));
        }
    }
}