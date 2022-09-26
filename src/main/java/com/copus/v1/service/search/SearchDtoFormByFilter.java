package com.copus.v1.service.search;

import com.copus.v1.repository.level.Lv1Repository;
import com.copus.v1.service.dto.search.SearchDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SearchDtoFormByFilter {
    private final Lv1Repository lv1Repository;
    public SearchDto searchDtoFormByFilter(String keyword){
        String lv1Id =
        return new SearchDto();
    }
}
// lv1, lv2, lv3, lv4=> 각각 아이디로 상위 정보 물어옴
// content => 본문 해당되는 lv4 아이다로 상위 정보 물어옴
// Rep => null 정보까지 물어오는 다중 쿼리(?)

// 필터 정보로 로직 분류 => 정보 찾아옴 => DTO로 반환