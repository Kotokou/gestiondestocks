package com.papdav.gestiondestocks.repository;

import com.papdav.gestiondestocks.dtos.UtilisateurDto;
import com.papdav.gestiondestocks.models.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {
    Optional<UtilisateurDto> findByNom(String nom);
}
