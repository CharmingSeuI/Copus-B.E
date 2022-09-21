package com.copus.v1.controller;

import com.copus.v1.controller.dto.SeojiRequest;
import com.copus.v1.controller.dto.SeojiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/article")
public class ArticleController {


    @GetMapping("/seoji")
    public SeojiResponse getSeoji(@ModelAttribute SeojiRequest seojiRequest) {
        SeojiResponse seojiResponse = new SeojiResponse();

        /**
         * Data For Seojies Article
         * @param keyword : 쿼리 검색용 키워드, value( all || 저자명 || 가나다 中 1 )
         * @param ordering : 쿼리 페이징 키워드, value( none || author ||| book )
         * @return{
         * 	"count":'',
         * 	"datas":[
        *       {
         * 		"seojiId":'',
         * 		"seojiTitle":'',
         * 		"authorName":'',
         * 		"zipsuStart":'',
         * 		"zipsuEnd":'',
         * 		"publishYear":'',
         * 		"buga":{
         * 		//부가 정보 있을 시 value == 서지 ID
         * 			"beomrye":'',
         * 			"chapter":'', //목차
         * 			"haejae":''
         *            }
         *      },...
         * }
         */

        return seojiResponse;
    }
}
