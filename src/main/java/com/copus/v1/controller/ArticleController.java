package com.copus.v1.controller;

import com.copus.v1.controller.dto.MuncheResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/article")
public class ArticleController {

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
}
