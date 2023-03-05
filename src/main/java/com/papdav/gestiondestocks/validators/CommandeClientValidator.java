package com.papdav.gestiondestocks.validators;

import com.papdav.gestiondestocks.dtos.CommandeClientDto;
import org.springframework.util.StringUtils;
import java.util.ArrayList;
import java.util.List;

public class CommandeClientValidator {

    public List<String> validate(CommandeClientDto commandeClientDto){
        List<String> errors = new ArrayList<>();

        if(commandeClientDto == null){
            errors.add("Vous devez renseigner le code de la commande client");
            errors.add("Vous devez renseigner la date de la commande client");
            errors.add("Vous devez renseigner le client de la commande client");
            errors.add("Vous devez renseigner au moins une ligne de commande pour la commande du client");
            return errors;
        }

        if(!StringUtils.hasLength(commandeClientDto.getCode())){
            errors.add("Vous devez renseigner le code de la commande client");
        }

        if(commandeClientDto.getDateDeCommande() == null){
            errors.add("Vous devez renseigner la date de la commande client");
        }

        if(commandeClientDto.getClient() == null){
            errors.add("Vous devez renseigner le client de la commande client");
        }

        if(commandeClientDto.getLigneCommandeClients().isEmpty() || commandeClientDto.getLigneCommandeClients().stream() == null){
            errors.add("Vous devez renseigner au moins une ligne de commande pour la commande du client");
        }
        return errors;
    }
}
