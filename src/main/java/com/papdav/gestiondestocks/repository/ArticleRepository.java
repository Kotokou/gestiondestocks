package com.papdav.gestiondestocks.repository;

import com.papdav.gestiondestocks.models.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public  interface ArticleRepository extends JpaRepository<Article, Integer> {

    public Optional<Article> findArticleByCodeArticle(String codeArticle);
}
