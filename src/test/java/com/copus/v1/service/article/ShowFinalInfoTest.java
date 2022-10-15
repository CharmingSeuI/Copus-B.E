package com.copus.v1.service.article;

import com.copus.v1.service.article.show.FinalService;
import com.copus.v1.service.article.show.SeojiService;
import com.copus.v1.service.enums.SeojiKeyword;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class ShowFinalInfoTest {

    @Autowired
    private FinalService finalService;

        @Test
        void FinalInfo(){
           System.out.println("FinalInfo:\n" + finalService.getFinalInfo("ITKC_MO_1237A_0040_010_0700"));

        }

}