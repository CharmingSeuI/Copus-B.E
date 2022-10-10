package com.copus.v1;

import com.copus.v1.controller.ArticleController;
import com.copus.v1.controller.dto.PreviewRequest;
import com.copus.v1.service.dto.article.SearchPreviewDataDto;
import com.copus.v1.service.dto.article.SearchPreviewDto;
import com.copus.v1.service.enums.SearchFilter;
import com.copus.v1.service.article.search.SearchPreview;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Transactional
class ApiTest {

    @Autowired
    private SearchPreview searchPreview;
    @Autowired
    private ArticleController articleController;


    @Test
    void api(){
        List<SearchPreviewDataDto> searchPreviewDataDtos = new ArrayList<>();
        SearchPreviewDto searchPreviewDto = new SearchPreviewDto(0, null);
        PreviewRequest previewRequest = new PreviewRequest("content","月");

        System.out.println("1."+ articleController.getPreview(previewRequest));
        System.out.println("2."+ searchPreview.getPreview(SearchFilter.valueOf("content"), "月"));
        searchPreview.getPreviewByContent(searchPreviewDataDtos,"月",searchPreviewDto);
        System.out.println("3."+searchPreviewDataDtos);
    }

}