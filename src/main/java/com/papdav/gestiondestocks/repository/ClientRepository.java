package com.papdav.gestiondestocks.repository;

import com.papdav.gestiondestocks.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {}
