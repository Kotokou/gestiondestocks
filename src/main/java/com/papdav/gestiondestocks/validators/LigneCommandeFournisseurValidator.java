package com.papdav.gestiondestocks.validators;

import com.papdav.gestiondestocks.dtos.LigneCommandeFournisseurDto;
import java.util.ArrayList;
import java.util.List;

public class LigneCommandeFournisseurValidator {

    public static List<String> validate(LigneCommandeFournisseurDto ligneCommandeFournisseurDto){
        List<String> errors = new ArrayList<>();

        if(ligneCommandeFournisseurDto == null){
            errors.add("Vous devez renseigner l'article de la ligne de commande fournisseur");
            errors.add("Vous devez renseigner la commande fournisseur de la ligne de commande fournisseur");
            return errors;
        }

        if(ligneCommandeFournisseurDto.getArticle() == null){
            errors.add("Vous devez renseigner l'article de la ligne de commande fournisseur");
        }

        if(ligneCommandeFournisseurDto.getCommandeFournisseur() == null){
            errors.add("Vous devez renseigner la commande fournisseur de la ligne de commande fournisseur");
        }
        return errors;
    }
}
