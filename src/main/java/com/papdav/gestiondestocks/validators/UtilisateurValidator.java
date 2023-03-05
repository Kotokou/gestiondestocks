package com.papdav.gestiondestocks.validators;

import com.papdav.gestiondestocks.dtos.UtilisateurDto;
import org.springframework.util.StringUtils;
import java.util.ArrayList;
import java.util.List;

public class UtilisateurValidator {
    public static List<String> validate(UtilisateurDto utilisateurDto){
        List<String> errors = new ArrayList<>();

        if(utilisateurDto == null){
            errors.add("Vous devez renseigner le nom de l'utilisateur");
            errors.add("Vous devez renseigner le prenom de l'utilisateur");
            errors.add("Vous devez renseigner le mot de passe  de l'utilisateur");
            errors.add("Vous devez renseigner l'adresse de l'utilisateur");
        }

        if(!StringUtils.hasLength(utilisateurDto.getNom())){
            errors.add("Vous devez renseigner le nom de l'utilisateur");
        }

        if(!StringUtils.hasLength(utilisateurDto.getPrenom())){
            errors.add("Vous devez renseigner le prenom de l'utilisateur");
        }
        if(!StringUtils.hasLength(utilisateurDto.getEmail())){
            errors.add("Vous devez renseigner l'email  de l'utilisateur");
        }

        if(!StringUtils.hasLength(utilisateurDto.getMotDePasse())){
            errors.add("Vous devez renseigner le mot de passe  de l'utilisateur");
        }

        if(utilisateurDto.getDateDeNaissance() == null){
            errors.add("Vous devez renseigner la date de naissance de l'utilisateur");
        }

        if(utilisateurDto.getAdresse() == null){
            errors.add("Vous devez renseigner l'adresse de l'utilisateur");
        } else{
            if(!StringUtils.hasLength(utilisateurDto.getAdresse().getAdresse1())){
                errors.add("Vous devez renseigner l'adresse 1 de l'utilisateur");
            }
            if(!StringUtils.hasLength(utilisateurDto.getAdresse().getPays())){
                errors.add("Vous devez renseigner le pays de l'utilisateur");
            }
            if(!StringUtils.hasLength(utilisateurDto.getAdresse().getVille())){
                errors.add("Vous devez renseigner la ville de l'utilisateur");
            }
            if(!StringUtils.hasLength(utilisateurDto.getAdresse().getCodePostale())){
                errors.add("Vous devez renseigner le code postale de l'utilisateur");
            }
        }

        return errors;
    }
}
