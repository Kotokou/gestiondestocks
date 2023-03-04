package com.papdav.gestiondestocks.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.papdav.gestiondestocks.models.Utilisateur;
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
    @JsonIgnore
    private String motDePasse;
    private String photo;
    private EntrepriseDto entreprise;
    private List<RolesDto> roles;

    public static UtilisateurDto fromEntity(Utilisateur utilisateur){
        if (utilisateur == null) {
            return null;
            // TODO throw Exception
        }
        return UtilisateurDto
                .builder()
                .id(utilisateur.getId())
                .nom(utilisateur.getNom())
                .prenom(utilisateur.getPrenom())
                .adresse(AdresseDto.fromEntity(utilisateur.getAdresse()))
                .email(utilisateur.getEmail())
                .dateDeNaissance(utilisateur.getDateDeNaissance())
                .photo(utilisateur.getPhoto())
                .entreprise(EntrepriseDto.fromEntity(utilisateur.getEntreprise()))
//                .roles(RolesDto.fromEntity(utilisateur.getRoles()))
                .build();
    }

    public static Utilisateur toEntity(UtilisateurDto utilisateurDto){
        if (utilisateurDto == null) {
            return null;
            // TODO throw Exception
        }

        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(utilisateurDto.getId());
        utilisateur.setNom(utilisateurDto.getNom());
        utilisateur.setPrenom(utilisateurDto.getPrenom());
        utilisateur.setAdresse(AdresseDto.toEntity(utilisateurDto.getAdresse()));
        utilisateur.setEmail(utilisateurDto.getEmail());
        utilisateur.setDateDeNaissance(utilisateurDto.getDateDeNaissance());
        utilisateur.setPhoto(utilisateurDto.getPhoto());
        utilisateur.setEntreprise(EntrepriseDto.toEntity(utilisateurDto.getEntreprise()));
//        utilisateur.setRoles();
        return utilisateur;
    }
}
