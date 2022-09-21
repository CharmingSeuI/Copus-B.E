package com.copus.v1.controller;

import com.copus.v1.controller.dto.FinalResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/article")
public class ArticleController {

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
