package tn.esprit.autoloc.domain;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;



@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Vehicule {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVehicule;
    private String immatriculation;
    private String marque;
    private String modele;
    @Enumerated(EnumType.STRING)
    private CategorieVehicule categorie;
    private BigDecimal tarifJournalier;
    @Enumerated(EnumType.STRING)
    private StatutVehicule statut;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agence_id")
    private Agence agence;

    @ManyToMany
    @JoinTable(name = "vehicule_equipement",
            joinColumns = @JoinColumn(name = "vehicule_id"),
            inverseJoinColumns = @JoinColumn(name = "equipement_id"))
    @ToString.Exclude @EqualsAndHashCode.Exclude
    private List<Equipement> equipements = new ArrayList<>();

    @OneToMany(mappedBy = "vehicule")
    @ToString.Exclude @EqualsAndHashCode.Exclude
    private List<Reservation> reservations = new ArrayList<>();

    @OneToMany(mappedBy = "vehicule")
    @ToString.Exclude @EqualsAndHashCode.Exclude
    private List<Maintenance> maintenances = new ArrayList<>();
}

