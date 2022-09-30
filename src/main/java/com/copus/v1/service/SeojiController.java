package com.copus.v1.service;

import com.copus.v1.domain.info.body.Content;
import com.copus.v1.domain.info.meta.*;
import com.copus.v1.domain.level.Lv1;
import com.copus.v1.domain.level.Lv2;
import com.copus.v1.domain.level.Lv3;
import com.copus.v1.domain.level.Lv4;
import com.copus.v1.repository.info.body.ContentRepository;
import com.copus.v1.repository.info.meta.AuthorRepository;
import com.copus.v1.repository.info.meta.PublishInfoRepository;
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
    private final AuthorRepository authorRepository;
    private final PublishInfoRepository publishInfoRepository;
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
        List<Lv1> seojies = lv1Repository.findAllByIdKeyword(keyword);
        for (Lv1 seoji : seojies) {
            Long metaInfoId = seoji.getMetaInfo().getId();

            String seojiTitle = getSeojiTitle(metaInfoId);

            String authorName = getAuthorName(metaInfoId);

            String publishYear = getPublishYear(metaInfoId);

            seojiPreviewDtos.add(
                    new SeojiPreviewDto(seoji.getId(), seojiTitle, authorName, publishYear,
                            null, null, null, null, null, null, null));
        }

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

    private void getPreviewByLv2Id(List<SeojiPreviewDto> seojiPreviewDtos, String keyword) {
        List<Lv1> seojies = lv1Repository.findAllByLv2IdKeyword(keyword);
        Lv2 gwoncha = lv2Repository.findOne(keyword);
        for (Lv1 seoji : seojies) {
            Long metaInfoId = seoji.getMetaInfo().getId();

            String seojiTitle = getSeojiTitle(metaInfoId);
            String authorName = getAuthorName(metaInfoId);
            String publishYear = getPublishYear(metaInfoId);

            String gwonchaId = keyword;
            String gwonchaTitle = getTitleByMetaInfoId(gwoncha.getMetaInfo().getId());

            seojiPreviewDtos.add(
                    new SeojiPreviewDto(seoji.getId(), seojiTitle, authorName, publishYear,
                            gwonchaId, gwonchaTitle, null, null, null, null, null));
        }
    }




    private void getPreviewByLv3Id(List<SeojiPreviewDto> seojiPreviewDtos, String keyword) {
        List<Lv1> seojies = lv1Repository.findAllByLv3IdKeyword(keyword);
        List<Lv2> gwonchas = lv2Repository.findAllByLv3IdKeyword(keyword);

        Lv3 munche = lv3Repository.findOne(keyword);

        for (Lv1 seoji : seojies) {
            Long metaInfoId = seoji.getMetaInfo().getId();

            String seojiTitle = getSeojiTitle(metaInfoId);
            String authorName = getAuthorName(metaInfoId);
            String publishYear = getPublishYear(metaInfoId);

            String gwonchaId = gwonchas.get(0).getId();
            String gwonchaTitle = getTitleByMetaInfoId(gwonchas.get(0).getMetaInfo().getId());

            String muncheId = keyword;
            String muncheTitle = getTitleByMetaInfoId(munche.getMetaInfo().getId());

            seojiPreviewDtos.add(
                    new SeojiPreviewDto(seoji.getId(), seojiTitle, authorName, publishYear,
                            gwonchaId, gwonchaTitle, muncheId, muncheTitle, null, null, null));
        }
    }


    private void getPreviewByLv4Id(List<SeojiPreviewDto> seojiPreviewDtos, String keyword) {
        List<Lv1> seojies = lv1Repository.findAllByLv4IdKeyword(keyword);
        List<Lv2> gwonchas = lv2Repository.findAllByLv4IdKeyword(keyword);
        List<Lv3> munches = lv3Repository.findAllByLv4IdKeyword(keyword);

        Lv4 finalInfo = lv4Repository.findOne(keyword);

        for (Lv1 seoji : seojies) {
            Long metaInfoId = seoji.getMetaInfo().getId();

            String seojiTitle = getSeojiTitle(metaInfoId);
            String authorName = getAuthorName(metaInfoId);
            String publishYear = getPublishYear(metaInfoId);

            String gwonchaId = gwonchas.get(0).getId();
            String gwonchaTitle = getTitleByMetaInfoId(gwonchas.get(0).getMetaInfo().getId());

            String muncheId = keyword;
            String muncheTitle = getTitleByMetaInfoId(munches.get(0).getMetaInfo().getId());

            String finalId = keyword;
            String finalTitle = getTitleByMetaInfoId(finalInfo.getMetaInfo().getId());

            seojiPreviewDtos.add(
                    new SeojiPreviewDto(seoji.getId(), seojiTitle, authorName, publishYear,
                            gwonchaId, gwonchaTitle, muncheId, muncheTitle, finalId, finalTitle, null));
        }
    }


    private void getPreviewByContent(List<SeojiPreviewDto> seojiPreviewDtos, String keyword) {

        List<Lv4> finalInfos = lv4Repository.findAllByContentKeyword(keyword);

        for (Lv4 lv4 : finalInfos) {

            Long bodyInfoId = lv4.getBodyInfo().getId();

            List<Lv1> seojies = lv1Repository.findAllByLv4IdKeyword(lv4.getId());
            List<Lv2> gwonchas = lv2Repository.findAllByLv4IdKeyword(lv4.getId());
            List<Lv3> munches = lv3Repository.findAllByLv4IdKeyword(lv4.getId());
            Long metaInfoId = seojies.get(0).getMetaInfo().getId();

            String seojiTitle = getSeojiTitle(metaInfoId);
            String authorName = getAuthorName(metaInfoId);
            String publishYear = getPublishYear(metaInfoId);

            String gwonchaId = gwonchas.get(0).getId();
            String gwonchaTitle = getTitleByMetaInfoId(gwonchas.get(0).getMetaInfo().getId());

            String muncheId = keyword;
            String muncheTitle = getTitleByMetaInfoId(munches.get(0).getMetaInfo().getId());

            String finalId = lv4.getId();
            String finalTitle = getTitleByMetaInfoId(lv4.getMetaInfo().getId());

            String content = contentRepository.findOneByBodyInfoId(bodyInfoId).get(0).getContentText();
            if(content.length()>200){
                content = content.substring(0,200);
            }

            seojiPreviewDtos.add(
                    new SeojiPreviewDto(seojies.get(0).getId(), seojiTitle, authorName, publishYear,
                            gwonchaId, gwonchaTitle, muncheId, muncheTitle, finalId, finalTitle, content));
        }
    }

    private void getPreviewByMuncheTitle(List<SeojiPreviewDto> seojiPreviewDtos, String keyword) {
        List<Lv3> munches = lv3Repository.findLv3ByLv3Title(keyword);

        for (Lv3 lv3 : munches) {

            List<Lv1> seojies = lv1Repository.findAllByLv3IdKeyword(lv3.getId());
            List<Lv2> gwonchas = lv2Repository.findAllByLv3IdKeyword(lv3.getId());

            Long metaInfoId = seojies.get(0).getMetaInfo().getId();

            String seojiTitle = getSeojiTitle(metaInfoId);
            String authorName = getAuthorName(metaInfoId);
            String publishYear = getPublishYear(metaInfoId);

            String gwonchaId = gwonchas.get(0).getId();
            String gwonchaTitle = getTitleByMetaInfoId(gwonchas.get(0).getMetaInfo().getId());

            String muncheId = lv3.getId();
            String muncheTitle = getTitleByMetaInfoId(munches.get(0).getMetaInfo().getId());

            seojiPreviewDtos.add(
                    new SeojiPreviewDto(seojies.get(0).getId(), seojiTitle, authorName, publishYear,
                            gwonchaId, gwonchaTitle, muncheId, muncheTitle, null, null, null));
        }
    }

    private void getPreviewByGwonchaTitle(List<SeojiPreviewDto> seojiPreviewDtos, String keyword) {
        List<Lv2> gwonchas = lv2Repository.findLv2ByLv2Title(keyword);
        System.out.println(gwonchas);

        for (Lv2 lv2 : gwonchas) {

            List<Lv1> seojies = lv1Repository.findAllByLv2IdKeyword(lv2.getId());

            Long metaInfoId = seojies.get(0).getMetaInfo().getId();

            String seojiTitle = getSeojiTitle(metaInfoId);
            String authorName = getAuthorName(metaInfoId);
            String publishYear = getPublishYear(metaInfoId);

            String gwonchaId = gwonchas.get(0).getId();
            String gwonchaTitle = getTitleByMetaInfoId(gwonchas.get(0).getMetaInfo().getId());


            seojiPreviewDtos.add(
                    new SeojiPreviewDto(seojies.get(0).getId(), seojiTitle, authorName, publishYear,
                            gwonchaId, gwonchaTitle, null, null, null, null, null));
        }
    }

    private void getPreviewByAuthorName(List<SeojiPreviewDto> seojiPreviewDtos, String keyword) {
        List<Lv1> seojies = lv1Repository.findLv1ByAuthorName(keyword);
        for (Lv1 seoji : seojies) {
            Long metaInfoId = seoji.getMetaInfo().getId();

            String seojiTitle = getSeojiTitle(metaInfoId);

            String authorName = getAuthorName(metaInfoId);

            String publishYear = getPublishYear(metaInfoId);

            seojiPreviewDtos.add(
                    new SeojiPreviewDto(seoji.getId(), seojiTitle, authorName, publishYear,
                            null, null, null, null, null, null, null));
        }
    }

    private void getPreviewByBookTitle(List<SeojiPreviewDto> seojiPreviewDtos, String keyword) {
        List<Lv1> seojies = lv1Repository.findLv1ByLv1Title(keyword);
        for (Lv1 seoji : seojies) {
            Long metaInfoId = seoji.getMetaInfo().getId();

            String seojiTitle = getSeojiTitle(metaInfoId);

            String authorName = getAuthorName(metaInfoId);

            String publishYear = getPublishYear(metaInfoId);

            seojiPreviewDtos.add(
                    new SeojiPreviewDto(seoji.getId(), seojiTitle, authorName, publishYear,
                            null, null, null, null, null, null, null));
        }
    }

    private void getPreviewByTotal(List<SeojiPreviewDto> seojiPreviewDtos, String keyword) {

    }

    public void getArticle() {

    }
}
