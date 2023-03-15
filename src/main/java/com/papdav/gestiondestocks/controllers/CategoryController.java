package com.papdav.gestiondestocks.controllers;

import com.papdav.gestiondestocks.dtos.CategoryDto;
import com.papdav.gestiondestocks.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import static com.papdav.gestiondestocks.utils.Constants.APP_ROOT;

@RestController
@RequestMapping(APP_ROOT + "/categories")
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CategoryDto> getAllCategories(){
        return categoryService.findAll();
    }

    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public CategoryDto getCategoryById(@PathVariable Integer id){
        return categoryService.findById(id);
    }

    @GetMapping(value = "/{code}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CategoryDto getCategoryByCode(@PathVariable String code){
        return categoryService.findByCode(code);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public CategoryDto createCategory(@RequestBody CategoryDto categoryDto){
        return categoryService.save(categoryDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        categoryService.delete(id);
    }
}
