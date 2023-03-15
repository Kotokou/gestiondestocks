package com.papdav.gestiondestocks.repository;

import com.papdav.gestiondestocks.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    Optional<Client> findByNom(String nom);
}
