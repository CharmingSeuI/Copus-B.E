package com.copus.v1.controller.dto;

import com.copus.v1.service.dto.category.GetTotalDataWithFilterDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TotalCountsResponse {
    private Long totalCount;
    private Long bookTitleCount;
    private Long authorNameCount;
    private Long gwonchaTitleCount;
    private Long muncheTitleCount;
    private Long contentCount;
    private Long dataIdCount;

    public TotalCountsResponse(GetTotalDataWithFilterDto totalData) {
        this.totalCount = totalData.getTotalCount();
        this.bookTitleCount = totalData.getBookTitleCount();
        this.authorNameCount = totalData.getAuthorNameCount();
        this.gwonchaTitleCount = totalData.getGwonchaTitleCount();
        this.muncheTitleCount = totalData.getMuncheTitleCount();
        this.contentCount = totalData.getContentCount();
        this.dataIdCount = totalData.getDataIdCount();
    }
}