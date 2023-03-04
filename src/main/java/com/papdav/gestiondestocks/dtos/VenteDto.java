package com.papdav.gestiondestocks.dtos;

import com.papdav.gestiondestocks.models.Vente;
import lombok.Builder;
import lombok.Data;
import java.time.Instant;

@Data
@Builder
public class VenteDto {

    private  Integer id;
    private String code;
    private Instant dateDeVente;
//    private List<LigneVenteDto> ligneVentes;
    private String commentaire;


    public static VenteDto fromEntity(Vente vente){
        if(vente == null){
            return null;
            // TODO throw Exception
        }
        return  VenteDto
                .builder()
                .id(vente.getId())
                .code(vente.getCode())
                .dateDeVente(vente.getDateDeVente())
                .commentaire(vente.getCommentaire())
                .build();
    }

    public static Vente toEntity(VenteDto venteDto){
        if(venteDto == null){
            return null;
            // TODO throw Exception
        }
        Vente vente = new Vente();
        vente.setId(venteDto.getId());
        vente.setCode(venteDto.getCode());
        vente.setDateDeVente(venteDto.getDateDeVente());
        vente.setCommentaire(venteDto.getCommentaire());
        return vente;
    }
}
