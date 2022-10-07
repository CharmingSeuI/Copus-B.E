package com.copus.v1.controller;

import com.copus.v1.controller.dto.ChildLevelResponse;
import com.copus.v1.controller.dto.TotalCountsResponse;
import com.copus.v1.service.category.child.GetChildLevelDataByAuthorName;
import com.copus.v1.service.category.child.GetChildLevelDataByBookTItle;
import com.copus.v1.service.category.count.GetTotalDataWithFilter;
import com.copus.v1.service.dto.category.GetChildLevelDataDto;
import com.copus.v1.service.dto.category.GetTotalDataWithFilterDto;
import com.copus.v1.service.enums.SearchFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryController {

    private final GetTotalDataWithFilter getTotalDataWithFilter;
    private final GetChildLevelDataByAuthorName getChildLevelDataByAuthorName;
    private final GetChildLevelDataByBookTItle getChildLevelDataByBookTItle;

    @GetMapping("/book/{depth}/{currentId}")
    public ChildLevelResponse getChildLevelsByBook(@PathVariable Long depth, @PathVariable String currentId) {
        List<GetChildLevelDataDto> childDatas = getChildLevelDataByBookTItle.getChildDataByBookTitle(currentId, depth);
        return new ChildLevelResponse(childDatas);
    }

    @GetMapping("/author/{depth}/{currentId}")
    public ChildLevelResponse getChildLevelsByAuthor(@PathVariable Long depth, @PathVariable String currentId) {
        List<GetChildLevelDataDto> childDatas = getChildLevelDataByAuthorName.getChildDataByAuthorName(currentId, depth);
        return new ChildLevelResponse(childDatas);
    }

    @GetMapping("/total")
    public TotalCountsResponse getTotalDataWithFilter(@RequestParam String filter, @RequestParam String keyword) {
        GetTotalDataWithFilterDto totalData = getTotalDataWithFilter.getSearchCount(SearchFilter.valueOf(filter), keyword);
        return new TotalCountsResponse(totalData);
    }
}