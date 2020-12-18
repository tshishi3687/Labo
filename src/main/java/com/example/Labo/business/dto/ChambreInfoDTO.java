package com.example.Labo.business.dto;

import lombok.*;

import java.util.List;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@ToString
public class ChambreInfoDTO implements IdentifiedDTO<Integer>{
    private Integer id;
    private String adresse;
    private String ville;
    private int place;
    private UtilisateurSimpleDTO geree;
    private List<Integer> reservations;
    private List<ActiviteeDTO> activite;
}
