package com.papdav.gestiondestocks.repository;

import com.papdav.gestiondestocks.models.Vente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VenteRepository extends JpaRepository<Vente, Integer> {}
