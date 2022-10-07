package com.copus.v1.service.dto.article;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GwonchaInfoDto {
    private String seojiId;
    private String seojiTitle;
    private List<DatasDto> datas;
}