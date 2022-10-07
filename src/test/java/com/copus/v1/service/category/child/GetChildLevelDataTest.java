package com.copus.v1.service.category.child;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class GetChildLevelDataTest {

    @Autowired
    private GetChildLevelDataByAuthorName getChildLevelDataByAuthorName;
    @Autowired
    private GetChildLevelDataByBookTItle getChildLevelDataByBookTItle;

    @Test
    void child(){
        System.out.println(getChildLevelDataByAuthorName.getChildDataByAuthorName("자",-1L));
        System.out.println(getChildLevelDataByBookTItle.getChildDataByBookTitle("아",0L));
    }

}