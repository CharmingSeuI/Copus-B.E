package com.copus.v1.service;

import com.copus.v1.domain.info.meta.AuthorInfo;
import com.copus.v1.domain.info.meta.MetaInfo;
import com.copus.v1.domain.info.meta.PublishInfo;
import com.copus.v1.domain.level.Lv1;
import com.copus.v1.repository.info.body.ContentRepository;
import com.copus.v1.repository.info.meta.TitleRepository;
import com.copus.v1.repository.level.Lv1Repository;
import com.copus.v1.repository.level.Lv2Repository;
import com.copus.v1.repository.level.Lv3Repository;
import com.copus.v1.repository.level.Lv4Repository;
import com.copus.v1.service.dto.SeojiFilter;
import com.copus.v1.service.dto.SeojiPreviewDto;
import com.copus.v1.service.exception.InvalidLevelIdException;
import com.copus.v1.service.exception.NoFilterForSeojiPreviewException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SeojiController {

    private final Lv1Repository lv1Repository;
    private final Lv2Repository lv2Repository;
    private final Lv3Repository lv3Repository;
    private final Lv4Repository lv4Repository;
    private final TitleRepository titleRepository;
    private final PublishInfo publishInfo;
    private final AuthorInfo authorInfo;
    private final ContentRepository contentRepository;

    public void getCount() {

    }

    public List<SeojiPreviewDto> getPreview(SeojiFilter seojiFilter, String keyword) {
        List<SeojiPreviewDto> seojiPreviewDtos = new ArrayList<>();
        //Filter & keyword -> Find Lv1 Id
        switch (seojiFilter) {
            case dataId -> getPreviewByDataId(seojiPreviewDtos, keyword);
            case content -> getPreviewByContent(seojiPreviewDtos, keyword);
            case muncheTitle -> getPreviewByMuncheTitle(seojiPreviewDtos, keyword);
            case gwonchaTitle -> getPreviewByGwonchaTitle(seojiPreviewDtos, keyword);
            case authorName -> getPreviewByAuthorName(seojiPreviewDtos, keyword);
            case bookTitle -> getPreviewByBookTitle(seojiPreviewDtos, keyword);
            case total -> getPreviewByTotal(seojiPreviewDtos, keyword);
            default -> throw new NoFilterForSeojiPreviewException("서지 프리뷰를 위한 필터가 존재하지 않습니다");
        }
        return seojiPreviewDtos;
    }

    private Integer getLevelDepthByLevelId(String levelId) {
        return Math.toIntExact(levelId.chars()
                .filter(c -> c == '_')
                .count() - 1);
    }

    private void getPreviewByDataId(List<SeojiPreviewDto> seojiPreviewDtos, String keyword) {
        switch (getLevelDepthByLevelId(keyword)) {
            //서지 ID
            case 1 -> getPreviewByLv1Id(seojiPreviewDtos, keyword);
            //권차 ID
            case 2 -> getPreviewByLv2Id(seojiPreviewDtos, keyword);
            //문체 ID
            case 3 -> getPreviewByLv3Id(seojiPreviewDtos, keyword);
            //최종정보 ID
            case 4 -> getPreviewByLv4Id(seojiPreviewDtos, keyword);
            default -> throw new InvalidLevelIdException("해당 레벨 깊이는 존재하지 않습니다");

        }
    }

    private void getPreviewByLv1Id(List<SeojiPreviewDto> seojiPreviewDtos, String keyword) {
        Lv1 seoji = lv1Repository.findOne(keyword);
        MetaInfo metaInfo = seoji.getMetaInfo();

    }


    private void getPreviewByLv2Id(List<SeojiPreviewDto> seojiPreviewDtos, String keyword) {

    }


    private void getPreviewByLv3Id(List<SeojiPreviewDto> seojiPreviewDtos, String keyword) {

    }


    private void getPreviewByLv4Id(List<SeojiPreviewDto> seojiPreviewDtos, String keyword) {

    }


    private void getPreviewByContent(List<SeojiPreviewDto> seojiPreviewDtos, String keyword) {

    }

    private void getPreviewByMuncheTitle(List<SeojiPreviewDto> seojiPreviewDtos, String keyword) {

    }

    private void getPreviewByGwonchaTitle(List<SeojiPreviewDto> seojiPreviewDtos, String keyword) {

    }

    private void getPreviewByAuthorName(List<SeojiPreviewDto> seojiPreviewDtos, String keyword) {

    }

    private void getPreviewByBookTitle(List<SeojiPreviewDto> seojiPreviewDtos, String keyword) {

    }

    private void getPreviewByTotal(List<SeojiPreviewDto> seojiPreviewDtos, String keyword) {

    }

    public void getArticle() {

    }
}
