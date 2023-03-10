package com.papdav.gestiondestocks.repository;

import com.papdav.gestiondestocks.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Integer, Category> {}
