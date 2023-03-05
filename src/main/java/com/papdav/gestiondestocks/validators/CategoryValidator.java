package com.papdav.gestiondestocks.validators;

import com.papdav.gestiondestocks.dtos.CategoryDto;
import org.springframework.util.StringUtils;
import java.util.ArrayList;
import java.util.List;

public class CategoryValidator {
    public static List<String> validate(CategoryDto categoryDto){
        List<String> errors = new ArrayList<>();

        if(categoryDto == null){
            errors.add("Vous devez renseigner le code de la catégorie");
            return errors;
        }

        if(!StringUtils.hasLength(categoryDto.getCode())){
            errors.add("Vous devez renseigner le code de la catégorie");
        }
        return errors;
    }
}
