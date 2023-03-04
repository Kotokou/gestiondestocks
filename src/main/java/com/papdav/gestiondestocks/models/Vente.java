package com.papdav.gestiondestocks.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;
import java.time.Instant;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "vente")
public class Vente extends AbstractEntity{
    @Column(name = "code")
    private String code;

    @Column(name = "dateDeVente")
    private Instant dateDeVente;

    @OneToMany(mappedBy = "vente")
    private List<LigneVente> ligneVentes;

    @Column(name = "commentaire")
    private String commentaire;
}
