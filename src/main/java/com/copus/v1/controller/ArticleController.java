package com.copus.v1.controller;

import com.copus.v1.controller.dto.*;
import com.copus.v1.service.article.search.SearchPreview;
import com.copus.v1.service.article.show.*;
import com.copus.v1.service.dto.article.*;
import com.copus.v1.service.enums.SearchFilter;
import com.copus.v1.service.enums.SeojiKeyword;
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

    private final BugaService bugaService;

    @GetMapping("/preview")
    public PreviewResponse getPreview(@ModelAttribute PreviewRequest previewRequest) {
        System.out.println("previewRequest = " + previewRequest);
        SearchPreviewDto previewDto = searchPreview.getPreview(SearchFilter.valueOf(previewRequest.getFilter()), previewRequest.getKeyword());
        System.out.println(previewDto);
        return new PreviewResponse(previewDto);
    }

    @GetMapping("/seoji")
    public SeojiResponse getSeoji(@ModelAttribute SeojiRequest seojiRequest) {
        SeojiInfoDto seojiDto = seojiService.getSeojiInfo(SeojiKeyword.valueOf(seojiRequest.getSeojiKeyword()), seojiRequest.getKeyword());
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
        MuncheInfoDto muncheInfo = muncheService.getMuncheInfo(id);
        return new MuncheResponse(muncheInfo);
    }

    @GetMapping("/final/{id}")
    public FinalResponse getFinal(@PathVariable String id) {
        FinalInfoDto finalInfo = finalService.getFinalInfo(id);
        return new FinalResponse(finalInfo);
    }

}