package com.papdav.gestiondestocks.validators;

import com.papdav.gestiondestocks.dtos.ClientDto;
import org.springframework.util.StringUtils;
import java.util.ArrayList;
import java.util.List;

public class ClientValidator {
    public static List<String> validate(ClientDto clientDto){
        List<String> errors = new ArrayList<>();

        if(clientDto == null){
            errors.add("Vous devez renseigner le nom du client");
            errors.add("Vous devez renseigner le prenom du client");
            errors.add("Vous devez renseigner l'email du client");
            errors.add("Vous devez renseigner le numéro de téléphone du client");
            return errors;
        }

        if(!StringUtils.hasLength(clientDto.getNom())){
            errors.add("Vous devez renseigner le nom du client");
        }

        if(!StringUtils.hasLength(clientDto.getPrenom())){
            errors.add("Vous devez renseigner le prenom du client");
        }

        if(!StringUtils.hasLength(clientDto.getMail())){
            errors.add("Vous devez renseigner l'email du client");
        }

        if(!StringUtils.hasLength(clientDto.getNumTel())){
            errors.add("Vous devez renseigner le numéro de téléphone du client");
        }
        return  errors;
    }
}
