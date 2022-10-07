package com.copus.v1.controller.dto;

import com.copus.v1.service.serviceDto.articleDto.showDto.SeojiInfoBugaDataDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * All Fields Default == Null
 * When Has Data, Value is Seoji Id
 */
@Data
public class SeojiBuga {
    private String beomrye;
    private String chapter;
    private String haejae;

    public SeojiBuga(SeojiInfoBugaDataDto buga) {
        this.beomrye = buga.getBeomrye();
        this.chapter = buga.getChapter();
        this.haejae = buga.getHaejae();
    }
}
