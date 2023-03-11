package com.papdav.gestiondestocks.controllers;

import com.papdav.gestiondestocks.dtos.ArticleDto;
import com.papdav.gestiondestocks.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;

import static com.papdav.gestiondestocks.utils.Constants.APP_ROOT;

@RestController
@RequestMapping(APP_ROOT + "/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ArticleDto createArticle(@RequestBody ArticleDto articleDto){
        return articleService.save(articleDto);
    }



}