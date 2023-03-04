package com.papdav.gestiondestocks.dtos;

import com.papdav.gestiondestocks.models.Category;
import lombok.Builder;
import lombok.Data;
import java.util.List;

@Data
@Builder
public class CategoryDto {

    private  Integer id;

    private  String code;

    private String designation;

    private List<ArticleDto> articles;

    public CategoryDto fromEntity(Category category){
        if(category == null) {
            return  null;
            // TODO throw Exception
        }
        return CategoryDto.builder()
                .id(category.getId())
                .code(category.getCode())
                .designation(category.getDesignation())
                .build();
    }

    public Category toEntity(CategoryDto categoryDto){
        if(categoryDto == null){
            return  null;
            // TODO throw Exception
        }
        return Category.builder()
                .code(categoryDto.getCode())
                .designation(categoryDto.getDesignation())
                .build();
    }

}
