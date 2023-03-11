package com.papdav.gestiondestocks.validators;

import com.papdav.gestiondestocks.dtos.EntrepriseDto;
import org.springframework.util.StringUtils;
import java.util.ArrayList;
import java.util.List;

public class EntrepriseValidator {
    public static List<String> validate(EntrepriseDto entrepriseDto){
        List<String> errors = new ArrayList<>();

        if(entrepriseDto == null){
            errors.add("Vous devez renseigner le nom de l'entreprise");
            errors.add("Vous devez renseigner l'email de l'entreprise");
            errors.add("Vous devez renseigner le code fiscal de l'entreprise");
            errors.add("Vous devez renseigner le numéro de téléphone de l'entreprise");
            errors.add("Vous devez renseigner le lien du site web de l'entreprise");
            errors.add("Vous devez renseigner l'adresse de l'entreprise");
            return errors;
        }

        if(!StringUtils.hasLength(entrepriseDto.getNom())){
            errors.add("Vous devez renseigner le nom de l'entreprise");
        }

        if(!StringUtils.hasLength(entrepriseDto.getMail())){
            errors.add("Vous devez renseigner l'email de l'entreprise");
        }

        if(!StringUtils.hasLength(entrepriseDto.getCodeFiscal())){
            errors.add("Vous devez renseigner le code fiscal de l'entreprise");
        }

        if(!StringUtils.hasLength(entrepriseDto.getNumTel())){
            errors.add("Vous devez renseigner le numéro de téléphone de l'entreprise");
        }

        if(!StringUtils.hasLength(entrepriseDto.getSiteWeb())){
            errors.add("Vous devez renseigner le lien du site web de l'entreprise");
        }

        if(entrepriseDto.getAdresse() == null){
            errors.add("Vous devez renseigner l'adresse de l'entreprise");
        } else{
            if(!StringUtils.hasLength(entrepriseDto.getAdresse().getAdresse1())){
                errors.add("Vous devez renseigner l'adresse 1 de l'entreprise");
            }
            if(!StringUtils.hasLength(entrepriseDto.getAdresse().getPays())){
                errors.add("Vous devez renseigner le pays de l'entreprise");
            }
            if(!StringUtils.hasLength(entrepriseDto.getAdresse().getVille())){
                errors.add("Vous devez renseigner la ville de l'entreprise");
            }
            if(!StringUtils.hasLength(entrepriseDto.getAdresse().getCodePostale())){
                errors.add("Vous devez renseigner le code postale de l'entreprise");
            }
        }
        return  errors;
    }
}
