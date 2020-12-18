package com.example.Labo.business.dto;

import lombok.*;

import java.util.List;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@ToString
public class UtilisateurChambreDTO implements IdentifiedDTO<Integer>{

    private Integer id;
    private String adresse;
    private String ville;
    private Integer place;
    private List<UtilisateurReservationDTO> reservation;
    private List<ActiviteeDTO> activite;

}
