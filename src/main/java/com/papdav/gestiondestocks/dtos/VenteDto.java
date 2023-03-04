package com.papdav.gestiondestocks.dtos;

import lombok.Builder;
import lombok.Data;
import java.time.Instant;
import java.util.List;

@Data
@Builder
public class VenteDto {

    private  Integer id;

    private String code;


    private Instant dateDeVente;

    private List<LigneVenteDto> ligneVentes;


    private String commentaire;
}