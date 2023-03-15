package com.papdav.gestiondestocks.repository;

import com.papdav.gestiondestocks.dtos.RolesDto;
import com.papdav.gestiondestocks.models.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface RolesRepository extends JpaRepository<Roles, Integer> {
    Optional<RolesDto> findByRoleName(String nom);
}
