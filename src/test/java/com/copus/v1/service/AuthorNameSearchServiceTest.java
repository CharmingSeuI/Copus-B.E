package com.copus.v1.service;

import com.copus.v1.repository.info.meta.AuthorRepository;
import com.copus.v1.service.dto.show.ShowAuthorNameDto;
import com.copus.v1.service.show.ShowAuthorName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.ArrayList;

@SpringBootTest
@Transactional


class AuthorNameSearchServiceTest {
    @Autowired
    ShowAuthorName showAuthorName;
    @Autowired
    AuthorRepository authorRepository;

    @Test
    void Author(){
        ArrayList<ShowAuthorNameDto> author1 = showAuthorName.showAuthorNameByConsonant("가");
        ArrayList<ShowAuthorNameDto> author2 = showAuthorName.showAuthorNameByConsonant("자");
        ArrayList<ShowAuthorNameDto> author3 = showAuthorName.showAuthorNameByConsonant("차");
        ArrayList<ShowAuthorNameDto> author4 = showAuthorName.showAuthorNameByConsonant("힣");
        ArrayList<ShowAuthorNameDto> author5 = showAuthorName.showAuthorNameByConsonant("a");


        System.out.println("결과1:"+ author1);
        System.out.println("결과2:"+ author2);
        System.out.println("결과3:"+ author3);
        System.out.println("결과4:"+ author4);
        System.out.println("결과5:"+ author5);


    }

}