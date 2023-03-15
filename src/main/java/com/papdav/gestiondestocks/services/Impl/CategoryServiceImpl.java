package com.papdav.gestiondestocks.services.Impl;

import com.papdav.gestiondestocks.dtos.CategoryDto;
import com.papdav.gestiondestocks.exceptions.EntityNotFoundException;
import com.papdav.gestiondestocks.exceptions.ErrorCodes;
import com.papdav.gestiondestocks.exceptions.InvalidEntityException;
import com.papdav.gestiondestocks.models.Category;
import com.papdav.gestiondestocks.repository.CategoryRepository;
import com.papdav.gestiondestocks.services.CategoryService;
import com.papdav.gestiondestocks.validators.CategoryValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryDto save(CategoryDto categoryDto) {
        List<String> errors = CategoryValidator.validate(categoryDto);
        if(!errors.isEmpty()){
            log.error("Category is not valid {}", categoryDto);
            throw new InvalidEntityException("La catégorie n'est pas valide", ErrorCodes.CATEGORY_NOT_VALID, errors);
        }
        return CategoryDto.fromEntity(categoryRepository.save(CategoryDto.toEntity(categoryDto)));
    }

    @Override
    public CategoryDto findById(Integer id) {
        if(id == null){
            log.error("Category ID is null");
            return null;
        }
        Optional<Category> category = categoryRepository.findById(id);
        CategoryDto categoryDto =  CategoryDto.fromEntity(category.get());
        return Optional.of(categoryDto).orElseThrow(
                () -> new EntityNotFoundException(
                        "Aucune category avec l'ID = " + id +  " n'a été trouvé dans la BDD",
                        ErrorCodes.CATEGORY_NOT_FOUND)
        );
    }

    @Override
    public CategoryDto findByCode(String code) {
        if(!StringUtils.hasLength(code)){
            log.error("Code is null");
            return null;
        }
        Optional<Category> category = categoryRepository.findByCode(code);
        CategoryDto categoryDto = CategoryDto.fromEntity(category.get());

        return Optional.of(categoryDto).orElseThrow(
                () -> new EntityNotFoundException(
                        "Aucune category avec le code = " + code +  " n'a été trouvé dans la BDD",
                        ErrorCodes.CATEGORY_NOT_FOUND)
        );
    }

    @Override
    public List<CategoryDto> findAll() {
        return categoryRepository.findAll().stream().map(CategoryDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if(id == null){
            log.error("Category ID id null");
            return;
        }
        categoryRepository.deleteById(id);

    }
}
