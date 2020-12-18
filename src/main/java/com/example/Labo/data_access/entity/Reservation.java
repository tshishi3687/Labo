package com.example.Labo.data_access.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, name = "npersonne")
    private int nPersonne;

    @Column(name = "dataarr")
    private LocalDate dateArrivee;

    @Column(name = "datedep")
    private LocalDate dateDepart;

    @ManyToOne
    @JoinColumn(name = "reserve")
    private Utilisateur reserve;

    @ManyToOne
    @JoinColumn(name = "estreservee")
    private Chambre estReservee;


}
