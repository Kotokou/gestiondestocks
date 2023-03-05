package com.papdav.gestiondestocks.validators;

import com.papdav.gestiondestocks.dtos.ArticleDto;
import org.springframework.util.StringUtils;
import java.util.ArrayList;
import java.util.List;

public class ArticleValidator {
    public List<String> validate(ArticleDto articleDto){
        List<String> errors = new ArrayList<>();

        if(articleDto == null){
            errors.add("Vous devez renseigner le code de l'article");
            errors.add("Vous devez renseigner la désignation de l'article");
            errors.add("Vous devez renseigner le prix unitaire HT de l'article");
            errors.add("Vous devez renseigner le prix unitaire TTC de l'article");
            errors.add("Vous devez renseigner le taux TVA de l'article");
            errors.add("Vous devez renseigner la catégorie de l'article");
            return errors;
        }

        if(!StringUtils.hasLength(articleDto.getCodeArticle())){
            errors.add("Vous devez renseigner le code de l'article");
        }

        if(!StringUtils.hasLength(articleDto.getDesignation())){
            errors.add("Vous devez renseigner la désignation de l'article");
        }

        if(articleDto.getPrixUnitaireHt() == null){
            errors.add("Vous devez renseigner le prix unitaire HT de l'article");
        }

        if(articleDto.getTauxTva() == null){
            errors.add("Vous devez renseigner le taux TVA de l'article");
        }

        if(articleDto.getPrixUnitaireTtc() == null){
            errors.add("Vous devez renseigner le prix unitaire TTC de l'article");
        }

        if(articleDto.getCategory() == null){
            errors.add("Vous devez renseigner la catégorie de l'article");
        }
        return  errors;
    }
}
