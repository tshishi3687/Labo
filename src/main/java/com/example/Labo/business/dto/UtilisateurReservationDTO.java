package com.example.Labo.business.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@ToString
public class UtilisateurReservationDTO implements IdentifiedDTO<Integer>{

    private Integer id;
    private Integer nPersonne;
    private LocalDateTime dateArrivee;
    private LocalDateTime dateDepart;
    private UtilisateurSimpleDTO reserve;
}
