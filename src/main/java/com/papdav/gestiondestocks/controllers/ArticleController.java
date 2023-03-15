package com.papdav.gestiondestocks.controllers;

import com.papdav.gestiondestocks.dtos.ArticleDto;
import com.papdav.gestiondestocks.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import static com.papdav.gestiondestocks.utils.Constants.APP_ROOT;

@RestController
@RequestMapping(APP_ROOT + "/articles")
public class ArticleController {


    private ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService){
        this.articleService = articleService;
    }


    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ArticleDto getArticleById(@PathVariable Integer id){
        return articleService.findById(id);
    }

    @GetMapping(value = "/{codeArticle}", produces = MediaType.APPLICATION_JSON_VALUE)
    ArticleDto getArticleByCodeArticle(@PathVariable String codeArticle){
        return articleService.findByCodeArticle(codeArticle);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    List<ArticleDto> getAllArticle(){
        return articleService.findAll();
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ArticleDto createArticle(@RequestBody ArticleDto articleDto){
        return articleService.save(articleDto);
    }

    @DeleteMapping("/{id}")
    void deleteArticle(@PathVariable Integer id){
        articleService.delete(id);
    }



}
