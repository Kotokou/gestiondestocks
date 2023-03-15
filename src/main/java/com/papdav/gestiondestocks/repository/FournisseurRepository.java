package com.papdav.gestiondestocks.repository;

import com.papdav.gestiondestocks.dtos.FournisseurDto;
import com.papdav.gestiondestocks.models.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface FournisseurRepository extends JpaRepository<Fournisseur, Integer> {
    Optional<FournisseurDto> findByNom(String nom);
}
