package com.copus.v1.service.article;

import com.copus.v1.service.enums.SeojiKeyword;
import com.copus.v1.service.enums.SeojiOrdering;
import com.copus.v1.service.article.show.SeojiService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static com.copus.v1.service.enums.SeojiKeyword.all;

@SpringBootTest
@Transactional
class ShowSeojiInfoTest {

    @Autowired
    private SeojiService showSeojiInfo;

        @Test
        void seaojiInfo(){
           System.out.println("all:\n" + showSeojiInfo.getSeojiInfo(SeojiKeyword.valueOf("all"), "none"));
           System.out.println("bookTitleConsonant:\n"+ showSeojiInfo.getSeojiInfo(SeojiKeyword.valueOf("bookTitleConsonant"),  "아"));
           System.out.println("authorNameConsonant:\n"+ showSeojiInfo.getSeojiInfo(SeojiKeyword.valueOf("authorNameConsonant"), "자"));
           System.out.println("authorName:\n"+ showSeojiInfo.getSeojiInfo(SeojiKeyword.valueOf("authorName"), "조성가"));

        }

}