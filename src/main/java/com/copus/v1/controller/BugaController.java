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
@RequestMapping("/buga")
public class BugaController {

    private final BugaService bugaService;


    @GetMapping("/beomrye/{id}")
    public BeomryeResponse getBeomrye(@PathVariable String id) {
        BeomryeDto beomrye= bugaService.getBeomryeInfo(id);
        return new BeomryeResponse(beomrye);
    }

    @GetMapping("/chapter/{id}")
    public ChapterResponse getChapter(@PathVariable String id) {
        ChapterDto chapter= bugaService.getChapterInfo(id);
        return new ChapterResponse(chapter);
    }
    @GetMapping("/haejae/{id}")
    public HaejaeResponse getHaejae(@PathVariable String id) {
        HaejaeDto haejae= bugaService.getHaejaeInfo(id);
        return new HaejaeResponse(haejae);
    }
}