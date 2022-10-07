package com.copus.v1.controller.dto;

import com.copus.v1.service.dto.article.MunchesDto;
import lombok.Data;

@Data
public class MunchePreview {
    private String muncheId;
    private String muncheTitle;

    public MunchePreview(MunchesDto munche) {
        muncheId = munche.getMuncheId();
        muncheTitle = munche.getMuncheTitle();
    }
}
