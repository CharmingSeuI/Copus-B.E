package com.copus.v1.service.search;

import com.copus.v1.domain.level.Lv2;
import com.copus.v1.repository.level.Lv1Repository;
import com.copus.v1.repository.level.Lv2Repository;
import com.copus.v1.repository.level.Lv3Repository;
import com.copus.v1.repository.level.Lv4Repository;
import com.copus.v1.service.dto.search.SearchTreesDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SearchTrees {
    private final Lv1Repository lv1Repository;
    private final Lv2Repository lv2Repository;
    private final Lv3Repository lv3Repository;
    private final Lv4Repository lv4Repository;

    SearchTreesDto searchTreesDto = new SearchTreesDto();

    public List<SearchTreesDto> SearchTrees(String filter, String keyword){
        if(filter == "authorName"|| filter == "bookTitle"){
            String lv1Id;
            if(filter=="authorName"){
                lv1Id = lv1Repository.findLv1ByAuthorName(keyword).get(0).getId();
            }else{
                lv1Id = lv1Repository.findLv1ByLv1Title(keyword).get(0).getId();
            }
            String lv2Id = lv2Repository.findLv2ByLv1Id(lv1Id).get(0).getId();
            String lv3Id = lv3Repository.findLv3ByLv2Id(lv2Id).get(0).getId();
            String lv4Id = lv4Repository.findLv4ByLv3Id(lv3Id).get(0).getId();
            new SearchTreesDto(lv1Id, lv2Id, lv3Id, lv4Id);
        } else if (filter == "gwoncha") {
            List<Lv2> lv2List= lv2Repository.findLv2ByLv1Id(keyword);
            for(Lv2 l2 : lv2List){

            }
            new SearchTreesDto(null, lv2Id, lv3Id, lv4Id);
        }

    };
}
