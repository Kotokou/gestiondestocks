package com.papdav.gestiondestocks.dtos;

import com.papdav.gestiondestocks.models.Utilisateur;
import lombok.Builder;
import lombok.Data;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

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
                .motDePasse(utilisateur.getMotDePasse())
                .email(utilisateur.getEmail())
                .dateDeNaissance(utilisateur.getDateDeNaissance())
                .photo(utilisateur.getPhoto())
                .entreprise(EntrepriseDto.fromEntity(utilisateur.getEntreprise()))
                .roles(
                        utilisateur.getRoles() != null ?
                        utilisateur.getRoles()
                                .stream()
                                .map(RolesDto::fromEntity)
                                .collect(Collectors.toList())
                        : null)
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
        utilisateur.setMotDePasse(utilisateurDto.getMotDePasse());
        utilisateur.setAdresse(AdresseDto.toEntity(utilisateurDto.getAdresse()));
        utilisateur.setEmail(utilisateurDto.getEmail());
        utilisateur.setDateDeNaissance(utilisateurDto.getDateDeNaissance());
        utilisateur.setPhoto(utilisateurDto.getPhoto());
        utilisateur.setEntreprise(EntrepriseDto.toEntity(utilisateurDto.getEntreprise()));
        utilisateur.setRoles(
                utilisateurDto.getRoles() != null ?
                utilisateurDto.getRoles()
                        .stream()
                        .map(RolesDto::toEntity)
                        .collect(Collectors.toList())
                        : null);
        return utilisateur;
    }
}
