package com.example.Labo.business.dto;

import lombok.*;

import java.util.List;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@ToString
public class UtilisateurInfoDTO implements IdentifiedDTO<Integer>{

    private Integer id;
    private String username;
    private String nom;
    private String prenom;
    private String email;
    private List<UtilisateurReservationDTO> reservation;
    private List<UtilisateurChambreDTO> chambre;
}
