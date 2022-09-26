package com.copus.v1.service.search;

import com.copus.v1.repository.level.Lv1Repository;
import com.copus.v1.repository.level.Lv2Repository;
import com.copus.v1.repository.level.Lv3Repository;
import com.copus.v1.repository.level.Lv4Repository;
import com.copus.v1.service.dto.search.SearchDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SearchService {


    private final Lv1Repository lv1Repository;
    private final Lv2Repository lv2Repository;
    private final Lv3Repository lv3Repository;
    private final Lv4Repository lv4Repository;

   // total || bookTitle || authorName || gwonchaTitle || muncheTitle || content || dataId

    public SearchDto search(String filter, String keyword) {
        if(filter == "total"){

        }else if(filter == "authorName") {

        }else if(filter == "bookTitle" ) {

        }else if(filter == "gwonchaTitle") {

        }else if(filter == "muncheTitle"){

        }else if(filter == "contentTitle") {

        }else if(filter == "content"){

        }else if(filter == "dataId"){

        }else{

        }
        return null;
    }


}
