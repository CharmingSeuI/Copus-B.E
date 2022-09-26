package com.copus.v1.service;

import com.copus.v1.service.search.SearchService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

@SpringBootTest
@Transactional

public class SearchServiceTest {

    @Autowired
    SearchService searchService;

    @Test
    void Category() {
        SearchByTotalDto result1_1 = searchService.searchByTotal("0");
        System.out.println("결과1_1:"+ result1_1);

        }
    }


