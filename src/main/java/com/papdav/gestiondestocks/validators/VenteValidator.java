package com.papdav.gestiondestocks.validators;

import com.papdav.gestiondestocks.dtos.VenteDto;
import org.springframework.util.StringUtils;
import java.util.ArrayList;
import java.util.List;

public class VenteValidator {

    public static List<String> validate(VenteDto venteDto){
        List<String> errors = new ArrayList<>();

        if(venteDto == null){
            errors.add("Vous devez renseigner le code de la vente");
            errors.add("Vous devez renseigner la date de la vente");
            errors.add("Vous devez renseigner le commentaire de la vente");
            return errors;
        }

        if(!StringUtils.hasLength(venteDto.getCode())){
            errors.add("Vous devez renseigner le code de la vente");
        }

        if(venteDto.getDateDeVente() == null){
            errors.add("Vous devez renseigner la date de la vente");
        }

        if(!StringUtils.hasLength(venteDto.getCommentaire())){
            errors.add("Vous devez renseigner le commentaire de la vente");
        }
        return errors;
    }
}
