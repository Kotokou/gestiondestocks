package com.papdav.gestiondestocks.validators;

import com.papdav.gestiondestocks.dtos.MvtDeStockDto;
import java.util.ArrayList;
import java.util.List;

public class MvtDeStockValidator {

    public static List<String> validate(MvtDeStockDto mvtDeStockDto){
        List<String> errors = new ArrayList<>();

        if(mvtDeStockDto == null){
            errors.add("Vous devez renseigner l'article du MvtDeStock");
            errors.add("Vous devez renseigner le type de MvtDeStock du MvtDeStock");
            errors.add("Vous devez renseigner la date du MvtDeStock");
            errors.add("Vous devez renseigner la quantité du MvtDeStock");
            return errors;
        }

        if(mvtDeStockDto.getArticle() == null){
            errors.add("Vous devez renseigner l'article du MvtDeStock");
        }

        if(mvtDeStockDto.getTypeDeMvtDeStock() == null){
            errors.add("Vous devez renseigner le type de MvtDeStock du MvtDeStock");
        }

        if(mvtDeStockDto.getDateMvt() == null){
            errors.add("Vous devez renseigner la date du MvtDeStock");
        }

        if(mvtDeStockDto.getQuantity() == null){
            errors.add("Vous devez renseigner la quantité du MvtDeStock");
        }
        return errors;
    }
}
