package com.copus.v1.service.category;

import com.copus.v1.domain.level.Lv1;
<<<<<<< HEAD
import com.copus.v1.domain.level.Lv4;
import com.copus.v1.repository.level.Lv1Repository;
=======
import com.copus.v1.domain.level.Lv2;
import com.copus.v1.domain.level.Lv3;
import com.copus.v1.domain.level.Lv4;
import com.copus.v1.repository.level.Lv1Repository;
import com.copus.v1.repository.level.Lv2Repository;
import com.copus.v1.repository.level.Lv3Repository;
>>>>>>> Feature_Category
import com.copus.v1.repository.level.Lv4Repository;
import com.copus.v1.service.dto.category.TotalCountDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TotalCountService {

    private final Lv1Repository lv1Repository;
<<<<<<< HEAD
=======
    private final Lv2Repository lv2Repository;
    private final Lv3Repository lv3Repository;
>>>>>>> Feature_Category
    private final Lv4Repository lv4Repository;


    public TotalCountDto totalCount(String keyword) {

        TotalCountDto totalCountDto = new TotalCountDto();

        List<Lv1> lv1List = lv1Repository.findLv1ByLv1Title(keyword);
        List<Lv1> lv1ListByAuthorName = lv1Repository.findLv1ByAuthorName(keyword);
<<<<<<< HEAD
        List<Lv4> lv4ListByContent = lv4Repository.findLv4ByContent(keyword);


        int lv1Count = lv1List.size();
        int lv1CountByAuthorName = lv1ListByAuthorName.size();
        int lv14ByContentCount = lv4ListByContent.size();
        int total = lv1Count+lv1CountByAuthorName+lv14ByContentCount;

        totalCountDto.setTotalCount(total);
        totalCountDto.setBookNameCount(lv1Count);
        totalCountDto.setAuthorNameCount(lv1CountByAuthorName);
=======
        List<Lv2> lv2List = lv2Repository.findLv2ByLv2Title(keyword);
        List<Lv3> lv3List = lv3Repository.findLv3ByLv3Title(keyword);
        List<Lv4> lv4List = lv4Repository.findLv4ByLv4Title(keyword);
        List<Lv4> lv4ListByContent = lv4Repository.findLv4ByContent(keyword);

        int lv1Count = lv1List.size();
        int lv1CountByAuthorName = lv1ListByAuthorName.size();
        int lv2Count = lv2List.size();
        int lv3Count = lv3List.size();
        int lv4Count = lv4List.size();
        int lv14ByContentCount = lv4ListByContent.size();
        int total = lv1Count+lv1CountByAuthorName+lv14ByContentCount;

        totalCountDto.setTotalCount(total);;
        totalCountDto.setBookNameCount(lv1Count);
        totalCountDto.setAuthorNameCount(lv1CountByAuthorName);
        totalCountDto.setGwonchaCount(lv2Count);
        totalCountDto.setMuncheCount(lv3Count);
        totalCountDto.setFinalTitleeCount(lv4Count);
>>>>>>> Feature_Category
        totalCountDto.setContentCount(lv14ByContentCount);

        return totalCountDto;
    }

}
