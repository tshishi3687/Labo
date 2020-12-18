package com.example.Labo.business.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@ToString
public class ActiviteeDTO implements IdentifiedDTO<Integer>{


    private Integer id;

    @Size (max = 20)
    @NotEmpty
    private String nom;

    @Size(max = 255)
    private String desc;



}
