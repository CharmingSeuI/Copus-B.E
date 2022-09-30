package com.copus.v1.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GwonchaInfoDto {
    private String seojiId;
    private String seojiTitle;
    private String authorName;
    private String zipsuStart;
    private String zipsuEnd;
    private String publishYear;

}