package com.papdav.gestiondestocks.repository;

import com.papdav.gestiondestocks.dtos.VenteDto;
import com.papdav.gestiondestocks.models.Vente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VenteRepository extends JpaRepository<Vente, Integer> {
    Optional<VenteDto> findByCode(String code);
}
