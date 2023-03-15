package com.papdav.gestiondestocks.repository;

import com.papdav.gestiondestocks.dtos.EntrepriseDto;
import com.papdav.gestiondestocks.models.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface EntrepriseRepository extends JpaRepository<Entreprise, Integer> {
    Optional<Entreprise> findByNom(String nom);
}
