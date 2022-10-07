package com.copus.v1.service.dto.category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetTotalDataWithFilterDto {
    private Long totalCount;
    private Long bookTitleCount;
    private Long authorNameCount;
    private Long gwonchaTitleCount;
    private Long muncheTitleCount;
    private Long contentCount;
    private Long dataIdCount;
}
