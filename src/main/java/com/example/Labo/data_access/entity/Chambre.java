package com.example.Labo.data_access.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Chambre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String adresse;

    @Column(nullable = false)
    private String ville;

    @Column(nullable = false)
    private int place;

    @ManyToOne
    @JoinColumn(name = "geree")
    private Utilisateur geree;

    @OneToMany(mappedBy = "estReservee")
    private List<Reservation> reservations;

    @ManyToMany
    @JoinTable(name = "aproximite", // nom de la colum de jointure
                joinColumns = @JoinColumn(name = "chambre_id", // nom de la colum fesant ref à chambre
                        referencedColumnName = "id"), // nom de la colum ref dans chambre
                inverseJoinColumns = @JoinColumn(name = "activitee_id", // nom de la colum fesant ref à activitée
             referencedColumnName = "id"))// nom fesant ref à la colum ref dans activité
    private List<Activitee> activite;




}
