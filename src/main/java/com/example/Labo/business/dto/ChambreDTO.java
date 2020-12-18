package com.example.Labo.business.dto;

import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@ToString
public class ChambreDTO implements IdentifiedDTO<Integer>{

    private Integer id;

    @NotEmpty
    @Size(min = 10, max = 100)
    private String adresse;

    @NotEmpty
    @Size(min = 2, max = 50)
    private String ville;

    @NotEmpty
    private int place;

    @Valid
    private UtilisateurSimpleDTO geree;

    @Valid
    private List<ActiviteeDTO>  activite;

}
