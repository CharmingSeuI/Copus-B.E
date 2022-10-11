package com.copus.v1.service.category.child;

import com.copus.v1.domain.info.meta.Author;
import com.copus.v1.domain.level.Lv1;
import com.copus.v1.domain.level.Lv2;
import com.copus.v1.domain.level.Lv3;
import com.copus.v1.domain.level.Lv4;
import com.copus.v1.repository.info.meta.AuthorRepository;
import com.copus.v1.repository.level.Lv1Repository;
import com.copus.v1.repository.level.Lv2Repository;
import com.copus.v1.repository.level.Lv3Repository;
import com.copus.v1.repository.level.Lv4Repository;
import com.copus.v1.service.ConsonantRangeSet;
import com.copus.v1.service.GetMetaInfo;
import com.copus.v1.service.dto.category.GetChildLevelDataDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class GetChildLevelData {

    private final Lv1Repository lv1Repository;
    private final Lv2Repository lv2Repository;
    private final Lv3Repository lv3Repository;
    private final Lv4Repository lv4Repository;
    private final AuthorRepository authorRepository;
    private final GetMetaInfo getMetaInfo;
    private final ConsonantRangeSet consonantRangeSet;
    private final static String[] consonantList ={"가","나","다","라","마","바","사","아","자","차","카","타","파","하"};

    public void getChildLv4ByLv3Id(String parentId, List<GetChildLevelDataDto> getChildLevelDataDtos) {
        List<Lv4> finalInfos = lv4Repository.findAllByLv3Id(parentId);
        for (Lv4 finalInfo : finalInfos) {
            Long metaInfoId = finalInfo.getMetaInfo().getId();
            String finalInfoTitle = getMetaInfo.getTitleByMetaInfoId(metaInfoId);
            getChildLevelDataDtos.add(new GetChildLevelDataDto(finalInfo.getId(), finalInfoTitle));
        }
    }

    public void getChildLv3ByLv2Id(String parentId, List<GetChildLevelDataDto> getChildLevelDataDtos) {
            List<Lv3> munches = lv3Repository.findAllByLv2Id(parentId);
            for (Lv3 munche : munches) {
                Long metaInfoId = munche.getMetaInfo().getId();
                String muncheTitle = getMetaInfo.getTitleByMetaInfoId(metaInfoId);
                getChildLevelDataDtos.add(new GetChildLevelDataDto(munche.getId(), muncheTitle));
            }
        }

    public void getChildLv2ByLv1Id(String parentId, List<GetChildLevelDataDto> getChildLevelDataDtos){
            List<Lv2> gwonchas= lv2Repository.findAllByLv1Id(parentId);
            for (Lv2 gwoncha : gwonchas) {
                Long metaInfoId = gwoncha.getMetaInfo().getId();
                String gwonchaTitle = getMetaInfo.getTitleByMetaInfoId(metaInfoId);
                getChildLevelDataDtos.add(new GetChildLevelDataDto(gwoncha.getId(), gwonchaTitle));
        }
    }

    public void getChildLv1ByAuthorName(String parentId, List<GetChildLevelDataDto> getChildLevelDataDtos){
        List<Lv1> seojies= lv1Repository.findLv1ByAuthorId(Long.parseLong(parentId));
        for (Lv1 seojie : seojies) {
            Long metaInfoId = seojie.getMetaInfo().getId();
            String seojieTitle = getMetaInfo.getSeojiTitleByMetaInfoId(metaInfoId);
            getChildLevelDataDtos.add(new GetChildLevelDataDto(seojie.getId(), seojieTitle));
        }
    }
    public void getChildLv1ByConsonant(String parentId, List<GetChildLevelDataDto> getChildLevelDataDtos){
        if(parentId.equals("all")){
            for(String consonant: consonantList) {
                List<Lv1> seojies= lv1Repository.findLv1ByConsonant(consonantRangeSet.consonantRangeSet(consonant).get(0), consonantRangeSet.consonantRangeSet(consonant).get(1));
                for (Lv1 seojie : seojies) {
                    Long metaInfoId = seojie.getMetaInfo().getId();
                    String seojieTitle = getMetaInfo.getSeojiTitleByMetaInfoId(metaInfoId);
                    getChildLevelDataDtos.add(new GetChildLevelDataDto(seojie.getId(), seojieTitle));
                }
            }
        }else{
            List<Lv1> seojies= lv1Repository.findLv1ByConsonant(consonantRangeSet.consonantRangeSet(parentId).get(0), consonantRangeSet.consonantRangeSet(parentId).get(1));
            for (Lv1 seojie : seojies) {
                Long metaInfoId = seojie.getMetaInfo().getId();
                String seojieTitle = getMetaInfo.getSeojiTitleByMetaInfoId(metaInfoId);
                getChildLevelDataDtos.add(new GetChildLevelDataDto(seojie.getId(), seojieTitle));
            }
        }

    }


    public void getChildAuthorNameByConsonant(String parentId, List<GetChildLevelDataDto> getChildLevelDataDtos){
        if(parentId.equals("all")){
            for(String consonant: consonantList){
                List<Author> authors= authorRepository.findAuthorNameByConsonant(consonantRangeSet.consonantRangeSet(consonant).get(0), consonantRangeSet.consonantRangeSet(consonant).get(1));;
                for (Author author : authors) {
                    getChildLevelDataDtos.add(new GetChildLevelDataDto(author.getId().toString(), author.concatNameKorAndChn()));
                }
            }
        }else{
        List<Author> authors= authorRepository.findAuthorNameByConsonant(consonantRangeSet.consonantRangeSet(parentId).get(0), consonantRangeSet.consonantRangeSet(parentId).get(1));;
        for (Author author : authors) {
            getChildLevelDataDtos.add(new GetChildLevelDataDto(author.getId().toString(), author.concatNameKorAndChn()));
        }
    }


}
}
