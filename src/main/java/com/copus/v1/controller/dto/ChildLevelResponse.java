package com.copus.v1.controller.dto;

import com.copus.v1.service.dto.category.GetChildLevelDataDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
public class ChildLevelResponse {
    private List<ChildLevel> datas = new ArrayList<>();

    public ChildLevelResponse(List<GetChildLevelDataDto> childDatas) {
        for (GetChildLevelDataDto childData : childDatas) {
            datas.add(new ChildLevel(childData));
        }
    }
}
