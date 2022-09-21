package com.copus.v1.controller;

import com.copus.v1.controller.dto.PreviewRequest;
import com.copus.v1.controller.dto.PreviewResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/article")
public class ArticleController {

    @GetMapping("/preview")
    public PreviewResponse getPreview(@ModelAttribute PreviewRequest previewRequest) {
        PreviewResponse previewResponse = new PreviewResponse();

        /**
         * Data For Search Result Article
         * @param Filter == 검색 필터 (total || bookTitle || authorName || gwonchaTitle || muncheTitle || content || dataId)
         * @param keyword == 검색어
         * @return {
         * 	"count":'',
         * 	"datas":[
         *                {
         * 			"seojiId":'',
         * 			"seojiTitle": '',
         * 			"authorName": '',
         * 			"publishYear":'',
         * 			"gwonchaId": '',  - if needContent is false, null
         * 			"gwonchaTitle": '권차명',  - if needContent is false, null
         * 			"muncheId": '',  - if needContent is false, null
         * 			"muncheTitle": '문체명',  - if needContent is false, null
         * 			"finalId":'', - if needContent is false, null
         * 			"finalTitle":'최종정보 제목', - if needContent is false, null
         * 			"contentPartition": '본문일부', //최대 200자  - if needContent is false, null
         *        },...
         * } if some field is null, make the block blanck
         */

        return previewResponse;
    }
}
