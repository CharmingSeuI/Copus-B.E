package com.copus.v1.service.search;

import com.copus.v1.domain.level.Lv1;
import com.copus.v1.domain.level.Lv2;
import com.copus.v1.domain.level.Lv3;
import com.copus.v1.domain.level.Lv4;
import com.copus.v1.repository.level.Lv1Repository;
import com.copus.v1.repository.level.Lv2Repository;
import com.copus.v1.repository.level.Lv3Repository;
import com.copus.v1.repository.level.Lv4Repository;
import com.copus.v1.service.dto.search.SearchByTotalDto;
import com.copus.v1.service.dto.search.SearchDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SearchByTotalService {


    private final Lv1Repository lv1Repository;
    private final Lv2Repository lv2Repository;
    private final Lv3Repository lv3Repository;
    private final Lv4Repository lv4Repository;


    private final SearchByContentService searchByContentService;
    private final Lv1Search lv1Search;
    private final Lv2Search lv2Search;
    private final Lv3Search lv3Search;
    private final Lv4Search lv4Search;
    private final ContentSearch contentSearch;
    private final AuthorNameSearch authorNameSearch;

    public SearchDto search(String filter, String keyword) {

    }

}
