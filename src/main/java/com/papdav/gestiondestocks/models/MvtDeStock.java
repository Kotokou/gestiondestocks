package com.papdav.gestiondestocks.models;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "mvtDeStock")
public class MvtDeStock extends AbstractEntity{

    @Column(name = "dateMvt")
    private Instant dateMvt;

    @Column(name = "quantity")
    private BigDecimal quantity;

    @Column(name = "typeDeMvtDeStock")
    private TypeDeMvtDeStock typeDeMvtDeStock;
    @ManyToOne
    @JoinColumn(name = "idArticle")
    private Article article;
}
