package com.copus.v1.service;

<<<<<<< HEAD
import com.copus.v1.repository.level.Lv3Repository;
=======
>>>>>>> Feature_Category
import com.copus.v1.service.dto.show.ShowLv3Dto;
import com.copus.v1.service.show.ShowMuncheService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.ArrayList;


@SpringBootTest
@Transactional
public class MuncheSearchServiceTest {

    @Autowired
    ShowMuncheService showMuncheService;

    @Test
    void showMunche(){
<<<<<<< HEAD
        ArrayList<ShowLv3Dto> lv3 = showMuncheService.searchLv3ByLv2Id("ITKC_MO_1237A_0010");
=======
        ArrayList<ShowLv3Dto> lv3 = showMuncheService.showLv3ByLv2Id("ITKC_MO_1237A_0010");
>>>>>>> Feature_Category

        System.out.println("결과:"+ lv3);
    }


}
