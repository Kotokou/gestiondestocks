package com.papdav.gestiondestocks.services;

import com.papdav.gestiondestocks.dtos.FournisseurDto;
import java.util.List;

public interface FournisseurService {
    FournisseurDto save(FournisseurDto fournisseurDto);

    FournisseurDto findById(Integer id);

    FournisseurDto findByNom(String nom);

    List<FournisseurDto> findAll();

    void delete(Integer id);
}
