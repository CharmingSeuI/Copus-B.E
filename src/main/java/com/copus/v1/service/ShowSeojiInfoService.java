package com.copus.v1.service;

import com.copus.v1.domain.info.meta.Author;
import com.copus.v1.domain.info.meta.PublishInfo;
import com.copus.v1.domain.info.meta.Title;
import com.copus.v1.domain.level.Lv1;
import com.copus.v1.repository.info.body.ContentRepository;
import com.copus.v1.repository.info.meta.AuthorRepository;
import com.copus.v1.repository.info.meta.PublishInfoRepository;
import com.copus.v1.repository.info.meta.TitleRepository;
import com.copus.v1.repository.level.Lv1Repository;
import com.copus.v1.repository.level.Lv2Repository;
import com.copus.v1.repository.level.Lv3Repository;
import com.copus.v1.repository.level.Lv4Repository;
import com.copus.v1.service.dto.*;
import com.copus.v1.service.exception.NoFilterForSeojiPreviewException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ShowSeojiInfoService {

    private final Lv1Repository lv1Repository;
    private final Lv2Repository lv2Repository;
    private final Lv3Repository lv3Repository;
    private final Lv4Repository lv4Repository;
    private final TitleRepository titleRepository;
    private final AuthorRepository authorRepository;
    private final PublishInfoRepository publishInfoRepository;
    private final ContentRepository contentRepository;

    public void getCount() {

    }

    public List<SeojiInfoDto> getSeojiInfo(SeojiKeyword seojiKeyword, SeojiOrdering seojiOrdering) {
        List<SeojiInfoDto> seojiInfoDtos = new ArrayList<>();
        switch (seojiKeyword) {
            case all -> getAllSeojiInfo(seojiInfoDtos);
            case authorName -> getSeojiInfoByAuthorName(seojiInfoDtos, seojiOrdering);
            case consonant -> getSeojiInfoByConsonant(seojiInfoDtos, seojiOrdering);

            default -> throw new NoFilterForSeojiPreviewException("서지 프리뷰를 위한 필터가 존재하지 않습니다");
        }
        return seojiInfoDtos;
    }





    private void getSeojiInfoByAuthorName(List<SeojiInfoDto> seojiInfoDtos, SeojiOrdering seojiOrdering) {
        switch (seojiOrdering) {
            case none -> none;
            case book -> ;
            case author -> ;
        }
    }
    private void getSeojiInfoByConsonant(List<SeojiInfoDto> seojiInfoDtos,SeojiOrdering seojiOrdering) {
        switch (seojiOrdering) {
            case none ->  ;
            case book ->;
            case author -> ;
        }
    }

    private void getAllSeojiInfo(List<SeojiInfoDto> seojiInfoDtos) {
        List<Lv1> seojies = lv1Repository.findAll();
        for (Lv1 seoji : seojies) {
            Long metaInfoId = seoji.getMetaInfo().getId();

            String seojiTitle = getSeojiTitle(metaInfoId);

            String authorName = getAuthorName(metaInfoId);
            String zipsuStart = getZipsuStart(metaInfoId);
            String zipsuEnd = getZipsuEnd(metaInfoId);

            String publishYear = getPublishYear(metaInfoId);

            seojiInfoDtos.add(
                    new SeojiInfoDto(seoji.getId(), seojiTitle, authorName,zipsuStart, zipsuEnd, publishYear));
        }
    }

    private String getZipsuStart(Long metaInfoId) {
        PublishInfo publishInfo = publishInfoRepository.findPublishInfoByMetaInfoId(metaInfoId);
        String zipsuStart = publishInfo.getZipsuStart();
        return zipsuStart;
    }

    private String getZipsuEnd(Long metaInfoId) {
        PublishInfo publishInfo = publishInfoRepository.findPublishInfoByMetaInfoId(metaInfoId);
        String zipsuEnd = publishInfo.getZipsuEnd();
        return zipsuEnd;
    }

    private String getPublishYear(Long metaInfoId) {
        PublishInfo publishInfo = publishInfoRepository.findPublishInfoByMetaInfoId(metaInfoId);
        String publishYear = publishInfo.getPublishYear();
        return publishYear;
    }

    private String getAuthorName(Long metaInfoId) {
        Author author = authorRepository.findAuthorByMetaInfoId(metaInfoId);
        String authorName = author.concatNameKorAndChn();
        return authorName;
    }

    private String getSeojiTitle(Long metaInfoId) {
        List<Title> titles = titleRepository.findTitleByMetaInfoId(metaInfoId);
        String titleKor = titles.get(1).getTitleText();
        String titleChn = titles.get(0).getTitleText();
        String seojiTitle = titleKor + "(" + titleChn + ")";
        return seojiTitle;
    }

    private String getTitleByMetaInfoId(Long metaInfoId) {
        List<Title> titles = titleRepository.findTitleByMetaInfoId(metaInfoId);
        String gwonchaTitle = titles.get(0).getTitleText();
        return gwonchaTitle;
    }
}
