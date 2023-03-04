package com.papdav.gestiondestocks.dtos;

import lombok.Builder;
import lombok.Data;
import java.time.Instant;
import java.util.List;

@Data
@Builder
public class UtilisateurDto {

    private  Integer id;

    private String nom;


    private String prenom;


    private AdresseDto adresse;

    private String email;


    private Instant dateDeNaissance;


    private String motDePasse;


    private String photo;


    private EntrepriseDto entreprise;


    private List<RolesDto> roles;
}
