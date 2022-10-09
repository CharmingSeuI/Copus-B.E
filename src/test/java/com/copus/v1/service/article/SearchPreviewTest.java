package com.copus.v1.service.article;

import com.copus.v1.service.enums.SearchFilter;
import com.copus.v1.service.article.search.SearchPreview;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class SearchPreviewTest {

    @Autowired
    private SearchPreview searchPreview;

    private SearchFilter searchFilter;

        @Test
        void searchController(){
           System.out.println("bookTitle1:\n" + searchPreview.getPreview(SearchFilter.valueOf("bookTitle"), "月"));
           System.out.println("bookTitle2:\n"+ searchPreview.getPreview(SearchFilter.valueOf("bookTitle"), "월"));
           System.out.println("authorName1:\n"+ searchPreview.getPreview(SearchFilter.valueOf("authorName"), "趙"));
           System.out.println("authorName2:\n"+ searchPreview.getPreview(SearchFilter.valueOf("authorName"), "조"));
           System.out.println("gwonchaTitle:\n"+ searchPreview.getPreview(SearchFilter.valueOf("gwonchaTitle"), "月"));
           System.out.println("muncheTitle:\n"+ searchPreview.getPreview(SearchFilter.valueOf("muncheTitle"), "詩"));
           System.out.println("content:\n"+ searchPreview.getPreview(SearchFilter.valueOf("content"), "詩"));
           System.out.println("dataId1:\n"+ searchPreview.getPreview(SearchFilter.valueOf("dataId"), "ITKC_MO_1237A"));
           System.out.println("dataId2:\n"+ searchPreview.getPreview(SearchFilter.valueOf("dataId"), "ITKC_MO_1237A_0040"));
           System.out.println("dataId3:\n"+ searchPreview.getPreview(SearchFilter.valueOf("dataId"), "ITKC_MO_1237A_0110_010"));
           System.out.println("dataId4:\n"+ searchPreview.getPreview(SearchFilter.valueOf("dataId"), "ITKC_MO_1237A_0010_010_0060"));
           System.out.println("total:\n"+ searchPreview.getPreview(SearchFilter.valueOf("total"), "月"));

        }

}