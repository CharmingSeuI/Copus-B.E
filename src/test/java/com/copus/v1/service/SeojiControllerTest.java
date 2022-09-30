package com.copus.v1.service;

import com.copus.v1.service.dto.SeojiFilter;
import com.copus.v1.service.dto.SeojiPreviewDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class SeojiControllerTest {

    @Autowired
    private SeojiController seojiController;


    private SeojiFilter seojiFilter;

        @Test
        void seojiController(){
           System.out.println("bookTitle1" + seojiController.getPreview(seojiFilter.bookTitle, "月皐集"));
           System.out.println("bookTitle2"+ seojiController.getPreview(seojiFilter.bookTitle, "월고집"));
           System.out.println("authorName1"+ seojiController.getPreview(seojiFilter.authorName, "趙性家"));
           System.out.println("authorName2"+ seojiController.getPreview(seojiFilter.authorName, "조성가"));
           System.out.println("gwonchaTitle"+ seojiController.getPreview(seojiFilter.gwonchaTitle, "月"));
           System.out.println("muncheTitle"+ seojiController.getPreview(seojiFilter.muncheTitle, "詩"));
           System.out.println("content"+ seojiController.getPreview(seojiFilter.content, "詩"));
           System.out.println("dataId1"+ seojiController.getPreview(seojiFilter.dataId, "ITKC_MO_1237A"));
           System.out.println("dataId2"+ seojiController.getPreview(seojiFilter.dataId, "ITKC_MO_1237A_0040"));
           System.out.println("dataId3"+ seojiController.getPreview(seojiFilter.dataId, "ITKC_MO_1237A_0110_010"));
           System.out.println("dataId4"+ seojiController.getPreview(seojiFilter.dataId, "ITKC_MO_1237A_0010_010_0060"));
           System.out.println("total"+ seojiController.getPreview(seojiFilter.total, "to"));

        }

}