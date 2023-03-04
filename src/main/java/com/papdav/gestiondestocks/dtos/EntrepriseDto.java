package com.papdav.gestiondestocks.dtos;

import com.papdav.gestiondestocks.models.Entreprise;
import lombok.Builder;
import lombok.Data;
import java.util.List;

@Data
@Builder
public class EntrepriseDto {

    private  Integer id;
    private String nom;
    private AdresseDto adresse;
    private String codeFiscal;
    private String photo;
    private String mail;
    private String numTel;
    private String siteWeb;
    private List<UtilisateurDto> utilisateurs;

    public static EntrepriseDto fromEntity(Entreprise entreprise){
        if(entreprise == null){
            return  null;
            // TODO throw Exception
        }
        return EntrepriseDto.builder()
                .id(entreprise.getId())
                .nom(entreprise.getNom())
                .codeFiscal(entreprise.getCodeFiscal())
                .adresse(AdresseDto.fromEntity(entreprise.getAdresse()))
                .photo(entreprise.getPhoto())
                .mail(entreprise.getMail())
                .numTel(entreprise.getNumTel())
                .siteWeb(entreprise.getSiteWeb())
                .build();
    }

    public static Entreprise toEntity(EntrepriseDto entrepriseDto){
        if(entrepriseDto == null){
            return  null;
            // TODO throw Exception
        }
        Entreprise entreprise = new Entreprise();
        entreprise.setId(entrepriseDto.getId());
        entreprise.setNom(entrepriseDto.getNom());
        entreprise.setAdresse(AdresseDto.toEntity(entrepriseDto.getAdresse()));
        entreprise.setMail(entrepriseDto.getMail());
        entreprise.setCodeFiscal(entrepriseDto.getCodeFiscal());
        entreprise.setPhoto(entrepriseDto.getPhoto());
        entreprise.setNumTel(entrepriseDto.getNumTel());
        entreprise.setSiteWeb(entrepriseDto.getSiteWeb());
        return entreprise;
    }
}
