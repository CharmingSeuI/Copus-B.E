package com.copus.v1.controller;

import com.copus.v1.controller.dto.GwonchaResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/article")
public class ArticleController {


    @GetMapping("/gwoncha/{id}")
    public GwonchaResponse getGwoncha(@PathVariable String id) {
        GwonchaResponse gwonchaResponse = new GwonchaResponse();

        /**
         * Gwoncha Data For  Article
         * @param Gwoncha id
         * @return
         * {
         * 	"seojiId":'',
         * 	"seojiTitle":'',
         * 	"datas":[
         *                {
         * 			"gwonchaId":'',
         * 			"gwonchaTitle":'',
         * 			"munches":[
         *                    {
         * 						"muncheId":'',
         * 						"muncheTitle":'',
         *                    },...
         * 				]
         *        },...
         * 	]
         * }
         */

        return gwonchaResponse;
    }
}
