package com.example.Labo.data_access.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Activitee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    private String nom;

    @Column(name = "description", nullable = false)
    private String desc;
}
