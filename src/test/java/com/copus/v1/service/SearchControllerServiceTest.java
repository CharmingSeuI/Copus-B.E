package com.copus.v1.service;

import com.copus.v1.service.dto.SearchFilter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class SearchControllerServiceTest {

    @Autowired
    private SearchControllerService searchControllerService;

    private SearchFilter searchFilter;

        @Test
        void seojiController(){
//           System.out.println("bookTitle1" + seojiControllerService.getPreview(seojiFilter.bookTitle, "月皐集"));
//           System.out.println("bookTitle2"+ seojiControllerService.getPreview(seojiFilter.bookTitle, "월고집"));
//           System.out.println("authorName1"+ seojiControllerService.getPreview(seojiFilter.authorName, "趙性家"));
//           System.out.println("authorName2"+ seojiControllerService.getPreview(seojiFilter.authorName, "조성가"));
//           System.out.println("gwonchaTitle"+ seojiControllerService.getPreview(seojiFilter.gwonchaTitle, "月"));
//           System.out.println("muncheTitle"+ seojiControllerService.getPreview(seojiFilter.muncheTitle, "詩"));
//           System.out.println("content"+ seojiControllerService.getPreview(seojiFilter.content, "詩"));
//           System.out.println("dataId1"+ seojiControllerService.getPreview(seojiFilter.dataId, "ITKC_MO_1237A"));
//           System.out.println("dataId2"+ seojiControllerService.getPreview(seojiFilter.dataId, "ITKC_MO_1237A_0040"));
//           System.out.println("dataId3"+ seojiControllerService.getPreview(seojiFilter.dataId, "ITKC_MO_1237A_0110_010"));
//           System.out.println("dataId4"+ seojiControllerService.getPreview(seojiFilter.dataId, "ITKC_MO_1237A_0010_010_0060"));
//           System.out.println("total"+ seojiControllerService.getPreview(seojiFilter.total, "月"));
          System.out.println("totalCount" + searchControllerService.getCount(searchControllerService.getPreview(searchFilter.total, "月")));

        }

}