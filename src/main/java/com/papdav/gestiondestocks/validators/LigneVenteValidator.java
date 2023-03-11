package com.papdav.gestiondestocks.validators;

import com.papdav.gestiondestocks.dtos.LigneVenteDto;
import java.util.ArrayList;
import java.util.List;

public class LigneVenteValidator {

    public static List<String> validate(LigneVenteDto ligneVenteDto){
        List<String> errors = new ArrayList<>();

        if(ligneVenteDto == null){
            errors.add("Vous devez renseigner le vente de la ligne de vente");
            errors.add("Vous devez renseigner le prix unitaire de la ligne de vente");
            errors.add("Vous devez renseigner la quantité de la ligne de vente");
            return errors;
        }

        if(ligneVenteDto.getVente() == null){
            errors.add("Vous devez renseigner le vente de la ligne de vente");
        }

        if(ligneVenteDto.getPrixUnitaire() == null){
            errors.add("Vous devez renseigner le prix unitaire de la ligne de vente");
        }

        if(ligneVenteDto.getQuantity() == null){
            errors.add("Vous devez renseigner la quantité de la ligne de vente");
        }

        return errors;

    }
}
