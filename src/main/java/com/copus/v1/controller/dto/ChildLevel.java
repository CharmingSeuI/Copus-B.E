package com.copus.v1.controller.dto;

import com.copus.v1.service.dto.category.GetChildLevelDataDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChildLevel {
    private String childId;
    private String childTitle;

    public ChildLevel(GetChildLevelDataDto childData) {
        this.childId = childData.getChildId();
        this.childTitle = childData.getChildTitle();
    }
}
