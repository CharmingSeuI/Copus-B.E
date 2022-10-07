package com.copus.v1.service.article.show;

import com.copus.v1.domain.level.Lv2;
import com.copus.v1.domain.level.Lv3;
import com.copus.v1.repository.level.Lv2Repository;
import com.copus.v1.repository.level.Lv3Repository;
import com.copus.v1.service.GetMetaInfo;
import com.copus.v1.service.serviceDto.articleDto.showDto.DatasDto;
import com.copus.v1.service.serviceDto.articleDto.showDto.GwonchaInfoDto;
import com.copus.v1.service.serviceDto.articleDto.showDto.MunchesDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ShowTotalGwonchaInfo {

    private final Lv2Repository lv2Repository;
    private final Lv3Repository lv3Repository;

    private final GetMetaInfo getMetaInfo;


}
