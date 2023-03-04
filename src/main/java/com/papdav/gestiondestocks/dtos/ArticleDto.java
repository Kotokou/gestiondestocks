package com.papdav.gestiondestocks.dtos;

import com.papdav.gestiondestocks.models.Article;
import lombok.Builder;
import lombok.Data;
import java.math.BigDecimal;

@Data
@Builder
public class ArticleDto {

    private  Integer id;
    private String codeArticle;
    private String designation;
    private BigDecimal prixUnitaireHt;
    private BigDecimal tauxTva;
    private BigDecimal prixUnitaireTtc;
    private String photo;
    private CategoryDto category;

    public static ArticleDto fromEntity(Article article){
        if(article == null) {
            return  null;
            // TODO throw Exception
        }
        return ArticleDto.builder()
                .id(article.getId())
                .designation(article.getDesignation())
                .codeArticle(article.getCodeArticle())
                .prixUnitaireHt(article.getPrixUnitaireHt())
                .prixUnitaireTtc(article.getPrixUnitaireTtc())
                .tauxTva(article.getTauxTva())
                .photo(article.getPhoto())
                .category(CategoryDto.fromEntity(article.getCategory()))
                .build();
    }

    public static Article toEntity(ArticleDto articleDto){
        if(articleDto == null){
            return  null;
            // TODO throw Exception
        }
        Article article = new Article();
        article.setId(articleDto.getId());
        article.setDesignation(articleDto.getDesignation());
        article.setCodeArticle(articleDto.getCodeArticle());
        article.setPrixUnitaireHt(articleDto.getPrixUnitaireHt());
        article.setPrixUnitaireTtc(articleDto.getPrixUnitaireTtc());
        article.setTauxTva(articleDto.getTauxTva());
        article.setCategory(CategoryDto.toEntity(articleDto.getCategory()));
        return article;
    }

}
