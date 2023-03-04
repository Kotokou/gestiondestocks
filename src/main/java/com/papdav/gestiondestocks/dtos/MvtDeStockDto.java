package com.papdav.gestiondestocks.dtos;

import com.papdav.gestiondestocks.models.TypeDeMvtDeStock;
import lombok.Builder;
import lombok.Data;
import java.math.BigDecimal;
import java.time.Instant;

@Data
@Builder
public class MvtDeStockDto {

    private  Integer id;

    private Instant dateMvt;


    private BigDecimal quantity;


    private TypeDeMvtDeStock typeDeMvtDeStock;


    private ArticleDto article;
}
