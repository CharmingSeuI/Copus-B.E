package com.copus.v1.service.dto.search;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SearchTreesDto {

    private String lv1Id;
    private String lv2Id;
    private String lv3Id;
    private String lv4Id;

    public SearchTreesDto(String newLv1Id, String newLv2Id, String newLv3Id, String newLv4Id){
        this.lv1Id = newLv1Id;
        this.lv2Id = newLv2Id;
        this.lv3Id = newLv3Id;
        this.lv4Id = newLv4Id;
    }
}
