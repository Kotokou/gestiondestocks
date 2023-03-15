package com.papdav.gestiondestocks.services;

import com.papdav.gestiondestocks.dtos.VenteDto;
import java.util.List;

public interface VenteService {
    VenteDto save(VenteDto venteDto);

    VenteDto findById(Integer id);

    VenteDto findByCode(String code);

    List<VenteDto> findAll();

    void delete(Integer id);
}
