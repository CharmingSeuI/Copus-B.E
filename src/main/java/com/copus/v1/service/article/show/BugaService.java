package com.copus.v1.service.article.show;

import com.copus.v1.domain.level.Lv1;
import com.copus.v1.repository.level.Lv1Repository;
import com.copus.v1.service.GetMetaInfo;
import com.copus.v1.service.dto.article.BeomryeDto;
import com.copus.v1.service.dto.article.ChapterDto;
import com.copus.v1.service.dto.article.HaejaeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BugaService {

    private final Lv1Repository lv1Repository;
    private final GetMetaInfo getMetaInfo;

    public BeomryeDto getBeomryeInfo(String level_1_Id){
        Lv1 seoji = lv1Repository.findOne(level_1_Id);
        Long metaInfoId = seoji.getMetaInfo().getId();
        String seojiTitle = getMetaInfo.getSeojiTitleByMetaInfoId(metaInfoId);
        String beomrye = getMetaInfo.getBeomrye(metaInfoId);

        return new BeomryeDto(seojiTitle, beomrye);
    }

    public ChapterDto getChapterInfo(String level_1_Id){
        Lv1 seoji = lv1Repository.findOne(level_1_Id);
        Long metaInfoId = seoji.getMetaInfo().getId();
        String seojiTitle = getMetaInfo.getSeojiTitleByMetaInfoId(metaInfoId);
        String chapter = getMetaInfo.getChapter(metaInfoId);

        return new ChapterDto(seojiTitle, chapter);
    }

    public HaejaeDto getHaejaeInfo(String level_1_Id){
        Lv1 seoji = lv1Repository.findOne(level_1_Id);
        Long metaInfoId = seoji.getMetaInfo().getId();
        String seojiTitle = getMetaInfo.getSeojiTitleByMetaInfoId(metaInfoId);
        String haejae = getMetaInfo.getHaejae(metaInfoId);

        return new HaejaeDto(seojiTitle, haejae);
    }


}