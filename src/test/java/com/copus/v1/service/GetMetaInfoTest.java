package com.copus.v1.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class GetMetaInfoTest {

    @Autowired
    private GetMetaInfo getMetaInfo;

        @Test
        void GetMetaInfo(){
            System.out.println(getMetaInfo.getZipsu(1L));
        }
}