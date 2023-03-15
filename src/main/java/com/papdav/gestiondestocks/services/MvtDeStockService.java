package com.papdav.gestiondestocks.services;

import com.papdav.gestiondestocks.dtos.MvtDeStockDto;
import java.util.List;

public interface MvtDeStockService {
    MvtDeStockDto save(MvtDeStockDto mvtDeStockDto);

    MvtDeStockDto findById(Integer id);

    List<MvtDeStockDto> findAll();

    void delete(Integer id);
}
