package com.papdav.gestiondestocks.validators;

import com.papdav.gestiondestocks.dtos.LigneCommandeClientDto;
import java.util.ArrayList;
import java.util.List;

public class LigneCommandeClientValidator {

    public static List<String> validate(LigneCommandeClientDto ligneCommandeClientDto){
        List<String> errors = new ArrayList<>();

        if(ligneCommandeClientDto == null){
            errors.add("Vous devez renseigner l'article de la ligne de commande client");
            errors.add("Vous devez renseigner la commande client de la ligne de commande client");
            return errors;
        }

        if(ligneCommandeClientDto.getArticle() == null){
            errors.add("Vous devez renseigner l'article de la ligne de commande client");
        }

        if(ligneCommandeClientDto.getCommandeClient() == null){
            errors.add("Vous devez renseigner la commande client de la ligne de commande client");
        }
        return errors;
    }
}
