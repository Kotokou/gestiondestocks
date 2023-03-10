package com.papdav.gestiondestocks.repository;

import com.papdav.gestiondestocks.models.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public  interface ArticleRepository extends JpaRepository<Integer, Article> {}
