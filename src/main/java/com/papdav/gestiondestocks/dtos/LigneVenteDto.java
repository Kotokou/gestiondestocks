package com.papdav.gestiondestocks.dtos;

import com.papdav.gestiondestocks.models.LigneVente;
import lombok.Builder;
import lombok.Data;
import java.math.BigDecimal;

@Data
@Builder
public class LigneVenteDto {

    private  Integer id;
    private VenteDto vente;
    private BigDecimal quantity;
    private BigDecimal prixUnitaire;


    public static LigneVenteDto fromEntity(LigneVente ligneVente){
        if(ligneVente == null){
            return null;
            //TODO throw Exception
        }
        return LigneVenteDto
                .builder()
                .id(ligneVente.getId())
                .quantity(ligneVente.getQuantity())
                .prixUnitaire(ligneVente.getPrixUnitaire())
                .vente(VenteDto.fromEntity(ligneVente.getVente()))
                .build();
    }

    public static LigneVente toEntity(LigneVenteDto ligneVenteDto){
        if(ligneVenteDto == null){
            return  null;
            // TODO throw Exception
        }
        LigneVente ligneVente = new LigneVente();
        ligneVente.setId(ligneVenteDto.getId());
        ligneVente.setQuantity(ligneVenteDto.getQuantity());
        ligneVente.setVente(VenteDto.toEntity(ligneVenteDto.getVente()));
        ligneVente.setPrixUnitaire(ligneVenteDto.getPrixUnitaire());
        return ligneVente;
    }
}
