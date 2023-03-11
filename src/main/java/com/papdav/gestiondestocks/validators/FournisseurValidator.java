package com.papdav.gestiondestocks.validators;

import com.papdav.gestiondestocks.dtos.FournisseurDto;
import org.springframework.util.StringUtils;
import java.util.ArrayList;
import java.util.List;

public class FournisseurValidator {

    public static List<String> validate(FournisseurDto fournisseurDto){
        List<String> errors = new ArrayList<>();

        if(fournisseurDto == null){
            errors.add("Vous devez renseigner le nom du fournisseur");
            errors.add("Vous devez renseigner le prenom du fournisseur");
            errors.add("Vous devez renseigner l'email du fournisseur");
            errors.add("Vous devez renseigner le numéro de téléphone du fournisseur");
            return errors;
        }

        if(!StringUtils.hasLength(fournisseurDto.getNom())){
            errors.add("Vous devez renseigner le nom du fournisseur");
        }

        if(!StringUtils.hasLength(fournisseurDto.getPrenom())){
            errors.add("Vous devez renseigner le prenom du fournisseur");
        }

        if(!StringUtils.hasLength(fournisseurDto.getMail())){
            errors.add("Vous devez renseigner l'email du fournisseur");
        }

        if(!StringUtils.hasLength(fournisseurDto.getNumTel())){
            errors.add("Vous devez renseigner le numéro de téléphone du fournisseur");
        }
        return  errors;
    }
}
