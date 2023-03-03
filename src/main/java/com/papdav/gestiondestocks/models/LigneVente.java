package com.papdav.gestiondestocks.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "ligneVente")
public class LigneVente extends  AbstractEntity{

    @ManyToOne
    @JoinColumn(name = "idVente")
    private Vente vente;

    @Column(name = "quantity")
    private BigDecimal quantity;
}
