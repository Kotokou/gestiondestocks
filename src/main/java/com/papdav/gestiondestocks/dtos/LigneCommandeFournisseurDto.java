package com.papdav.gestiondestocks.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LigneCommandeFournisseurDto {

    private  Integer id;

    private ArticleDto article;


    private CommandeFournisseurDto commandeFournisseur;
}
