package com.papdav.gestiondestocks.services;

import com.papdav.gestiondestocks.dtos.RolesDto;
import java.util.List;

public interface RolesService {
    RolesDto save(RolesDto rolesDto);

    RolesDto findById(Integer id);

    RolesDto findByRoleName(String nom);

    List<RolesDto> findAll();

    void delete(Integer id);
}
