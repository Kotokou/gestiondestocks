package com.papdav.gestiondestocks.services;

import com.papdav.gestiondestocks.dtos.CategoryDto;
import java.util.List;

public interface CategoryService {

    CategoryDto save(CategoryDto categoryDto);

    CategoryDto findById(Integer id);

    CategoryDto findByCode(String code);

    List<CategoryDto> findAll();

    void delete(Integer id);
}
