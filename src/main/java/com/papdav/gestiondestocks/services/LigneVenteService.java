package com.papdav.gestiondestocks.services;

import com.papdav.gestiondestocks.dtos.LigneVenteDto;
import java.util.List;

public interface LigneVenteService {
    LigneVenteDto save(LigneVenteDto ligneVenteDto);

    LigneVenteDto findById(Integer id);

    List<LigneVenteDto> findAll();

    void delete(Integer id);
}
