package com.papdav.gestiondestocks.dtos;

import lombok.Builder;
import lombok.Data;
import java.time.Instant;
import java.util.List;

@Data
@Builder
public class CommandeFournisseurDto {

    private  Integer id;

    private String code;


    private Instant dateDeCommande;


    private FournisseurDto fournisseur;


    private List<LigneCommandeFournisseurDto> ligneCommandeFournisseurs;
}
