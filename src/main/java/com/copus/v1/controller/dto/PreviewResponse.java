package com.copus.v1.controller.dto;

import com.copus.v1.service.dto.article.SearchPreviewDataDto;
import com.copus.v1.service.dto.article.SearchPreviewDto;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PreviewResponse {
    private int count;
    private List<SeojiPreview> datas = new ArrayList<>();

    public PreviewResponse(SearchPreviewDto previewDto) {
        count = previewDto.getCount();
        for (SearchPreviewDataDto data : previewDto.getData()) {
            datas.add(new SeojiPreview(data));
        }
    }
}
