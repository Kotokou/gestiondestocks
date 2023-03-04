package com.papdav.gestiondestocks.dtos;

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
}
