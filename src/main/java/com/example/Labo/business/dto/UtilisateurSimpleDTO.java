package com.example.Labo.business.dto;

import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@ToString
public class UtilisateurSimpleDTO implements IdentifiedDTO<Integer>{

    private Integer id;
}
