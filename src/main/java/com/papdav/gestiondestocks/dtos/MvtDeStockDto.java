package com.papdav.gestiondestocks.dtos;

import com.papdav.gestiondestocks.models.MvtDeStock;
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

    public static MvtDeStockDto fromEntity(MvtDeStock mvtDeStock){
        if(mvtDeStock == null){
            return null;
            // TODO throw Exception
        }
        return MvtDeStockDto
                .builder()
                .id(mvtDeStock.getId())
                .dateMvt(mvtDeStock.getDateMvt())
                .quantity(mvtDeStock.getQuantity())
                .typeDeMvtDeStock(mvtDeStock.getTypeDeMvtDeStock())
                .article(ArticleDto.fromEntity(mvtDeStock.getArticle()))
                .build();
    }

    public static MvtDeStock toEntity(MvtDeStockDto mvtDeStockDto){
        if(mvtDeStockDto == null){
            return null;
            // TODO throw Exception
        }
        MvtDeStock mvtDeStock =  new MvtDeStock();
        mvtDeStock.setId(mvtDeStock.getId());
        mvtDeStock.setDateMvt(mvtDeStockDto.getDateMvt());
        mvtDeStock.setQuantity(mvtDeStockDto.getQuantity());
        mvtDeStock.setTypeDeMvtDeStock(mvtDeStockDto.getTypeDeMvtDeStock());
        mvtDeStock.setArticle(ArticleDto.toEntity(mvtDeStockDto.getArticle()));
        return mvtDeStock;
    }
}
