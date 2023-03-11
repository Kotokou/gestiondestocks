package com.papdav.gestiondestocks.services.Impl;

import com.papdav.gestiondestocks.dtos.ArticleDto;
import com.papdav.gestiondestocks.exceptions.EntityNotFoundException;
import com.papdav.gestiondestocks.exceptions.ErrorCodes;
import com.papdav.gestiondestocks.exceptions.InvalidEntityException;
import com.papdav.gestiondestocks.models.Article;
import com.papdav.gestiondestocks.repository.ArticleRepository;
import com.papdav.gestiondestocks.services.ArticleService;
import com.papdav.gestiondestocks.validators.ArticleValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ArticleServiceImpl implements ArticleService {

    // Injection par constructeur
    private ArticleRepository articleRepository;
    @Autowired
    public ArticleServiceImpl(ArticleRepository articleRepository){

        this.articleRepository = articleRepository;
    }

    @Override
    public ArticleDto save(ArticleDto articleDto) {
        List<String> errors = ArticleValidator.validate(articleDto);
        if(!errors.isEmpty()){
            log.error("Article is not valid {}", articleDto);
            throw new InvalidEntityException("L'article n'est pas valide", ErrorCodes.ARTICLE_NOT_VALID, errors);
        }
        return ArticleDto.fromEntity(
                articleRepository.
                        save(ArticleDto.toEntity(articleDto)
                        )
        );
    }

    @Override
    public ArticleDto findById(Integer id) {
        if(id == null){
            log.error("Article ID is null");
            return null;
        }

        Optional<Article> articleOptional = articleRepository.findById(id);
        ArticleDto articleDto = ArticleDto.fromEntity(articleOptional.get());

        return Optional.of(articleDto).orElseThrow(
                () -> new EntityNotFoundException(
                        "Aucun article avec l'ID = " + id +  " n'a été trouvé dans la BDD",
                        ErrorCodes.ARTICLE_NOT_FOUND)
        );

    }

    @Override
    public ArticleDto findByCodeArticle(String codeArticle) {
        if(!StringUtils.hasLength(codeArticle)){
            log.error("Code Article is null");
            return null;
        }

        Optional<Article> articleOptional = articleRepository.findArticleByCodeArticle(codeArticle);
        ArticleDto articleDto = ArticleDto.fromEntity(articleOptional.get());

        return Optional.of(articleDto).orElseThrow(
                () -> new EntityNotFoundException(
                        "Aucun article avec le code article = " + codeArticle +  " n'a été trouvé dans la BDD",
                        ErrorCodes.ARTICLE_NOT_FOUND)
        );
    }

    @Override
    public List<ArticleDto> findAll() {
        List<Article> articles = articleRepository.findAll();
        return articles.stream().map(ArticleDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if(id == null){
            log.error("Article ID is null");
            return;
        }else{
            articleRepository.deleteById(id);
        }
    }
}
