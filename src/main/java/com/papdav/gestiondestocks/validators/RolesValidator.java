package com.papdav.gestiondestocks.validators;

import com.papdav.gestiondestocks.dtos.RolesDto;
import org.springframework.util.StringUtils;
import java.util.ArrayList;
import java.util.List;

public class RolesValidator {

    public static List<String> validate(RolesDto rolesDto){
        List<String> errors = new ArrayList<>();

        if(rolesDto == null){
            errors.add("Vous devez renseigner le nom du role");
            return errors;
        }

        if(!StringUtils.hasLength(rolesDto.getRoleName())){
            errors.add("Vous devez renseigner le nom du role");
        }
        return errors;
    }
}
