package com.copus.v1.controller;

import com.copus.v1.controller.dto.*;
import com.copus.v1.service.article.search.SearchPreview;
import com.copus.v1.service.article.show.FinalService;
import com.copus.v1.service.article.show.GwonchaService;
import com.copus.v1.service.article.show.MuncheService;
import com.copus.v1.service.article.show.SeojiService;
import com.copus.v1.service.enums.SearchFilter;
import com.copus.v1.service.enums.SeojiKeyword;
import com.copus.v1.service.serviceDto.articleDto.searchDto.SearchPreviewDto;
import com.copus.v1.service.serviceDto.articleDto.showDto.GwonchaInfoDto;
import com.copus.v1.service.serviceDto.articleDto.showDto.SeojiInfoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/article")
public class ArticleController {
    private final SearchPreview searchPreview;
    private final SeojiService seojiService;
    private final GwonchaService gwonchaService;
    private final MuncheService muncheService;
    private final FinalService finalService;

    @GetMapping("/preview")
    public PreviewResponse getPreview(@ModelAttribute PreviewRequest previewRequest) {
        SearchPreviewDto previewDto = searchPreview.getPreview(SearchFilter.valueOf(previewRequest.getFilter()), previewRequest.getKeyword());
        return new PreviewResponse(previewDto);
    }

    @GetMapping("/seoji")
    public SeojiResponse getSeoji(@ModelAttribute SeojiRequest seojiRequest) {
        SeojiInfoDto seojiDto = seojiService.getSeojiInfo(SeojiKeyword.valueOf(seojiRequest.getOrdering()), seojiRequest.getKeyword());
        return new SeojiResponse(seojiDto);
    }

    @GetMapping("/gwoncha/{id}")
    public GwonchaResponse getGwoncha(@PathVariable String id) {
        GwonchaInfoDto gwonchaInfo;
        if (getLevelOfId(id) == 1) gwonchaInfo = gwonchaService.getGwonchaInfoWithAllMunche(id);
        else gwonchaInfo = gwonchaService.getGwonchaInfo(id);
        return new GwonchaResponse(gwonchaInfo);
    }

    private int getLevelOfId(String id) {
        int level = Math.toIntExact(id.chars()
                .filter(c -> c == '_')
                .count() - 1);
        return level;
    }

    @GetMapping("/munche/{id}")
    public MuncheResponse getMunche(@PathVariable String id) {
        MuncheResponse muncheResponse = new MuncheResponse();

        /**
         * Munche Data for Article
         * @return{
         * 	"seojiId":'',
         * 	"seojiTitle":'',
         * 	"gwonchaId":'',
         * 	"gwonchaTitle":'',
         * 	"muncheTitle":'',
         * 	"finals":[
         *                {
         * 			"finalId":'',
         * 			"finalTitle":'',
         *        },...
         * 	]
         * }
         */

        return muncheResponse;
    }

    @GetMapping("/final/{id}")
    public FinalResponse getFinal(@PathVariable String id) {
        FinalResponse finalResponse = new FinalResponse();

        /**
         * Final Data for Article
         * @return{
         * 	"seojiId":'',
         * 	"seojiTitle":'',
         * 	"gwonchaId":'',
         * 	"gwonchaTitle":'',
         * 	"muncheId":'',
         * 	"muncheTitle":'',
         * 	"final":{
         * 		"title":'',
         * 		"content":'',
         *        }
         * }
         */

        return finalResponse;
    }
}