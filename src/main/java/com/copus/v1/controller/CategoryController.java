package com.copus.v1.controller;

import com.copus.v1.controller.dto.TotalCountsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryController {

    @GetMapping("/total")
    public TotalCountsResponse getTotalDataWithFilter(@RequestParam String filter, @RequestParam String keyword) {
        TotalCountsResponse totalCountsResponse = new TotalCountsResponse();

        /**
         * @param filter: total || bookTitle || authorName || content - 필터 종류
         * @param keyword : 검색바로 넘어오는 검색어
         * @return{
         *      if filter == total : 모든 필터 종류별 개수 ex. 15, 12, 2, 1
         *      else : 해당 필터 개수만 ex. bookTitle - 3, 3, 0, 0
         *      }
         */

        return totalCountsResponse;
    }
}

