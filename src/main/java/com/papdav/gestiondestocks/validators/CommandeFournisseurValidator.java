package com.papdav.gestiondestocks.validators;

import com.papdav.gestiondestocks.dtos.CommandeFournisseurDto;
import org.springframework.util.StringUtils;
import java.util.ArrayList;
import java.util.List;

public class CommandeFournisseurValidator {

    public List<String> validate(CommandeFournisseurDto commandeFournisseurDto){
        List<String> errors = new ArrayList<>();

        if(commandeFournisseurDto == null){
            errors.add("Vous devez renseigner le code de la commande fournisseur");
            errors.add("Vous devez renseigner la date de la commande fournisseur");
            errors.add("Vous devez renseigner le client de la commande fournisseur");
            errors.add("Vous devez renseigner au moins une ligne de commande pour la commande du fournisseur");
            return errors;
        }

        if(!StringUtils.hasLength(commandeFournisseurDto.getCode())){
            errors.add("Vous devez renseigner le code de la commande fournisseur");
        }

        if(commandeFournisseurDto.getDateDeCommande() == null){
            errors.add("Vous devez renseigner la date de la commande fournisseur");
        }

        if(commandeFournisseurDto.getFournisseur() == null){
            errors.add("Vous devez renseigner le client de la commande fournisseur");
        }

        if(commandeFournisseurDto.getLigneCommandeFournisseurs().isEmpty() || commandeFournisseurDto.getLigneCommandeFournisseurs().stream() == null){
            errors.add("Vous devez renseigner au moins une ligne de commande pour la commande du fournisseur");
        }
        return errors;
    }
}
