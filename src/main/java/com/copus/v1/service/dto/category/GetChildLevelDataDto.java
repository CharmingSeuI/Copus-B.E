package com.copus.v1.service.dto.category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetChildLevelDataDto {
    private String ChildId;
    private String ChildTitle;
}
