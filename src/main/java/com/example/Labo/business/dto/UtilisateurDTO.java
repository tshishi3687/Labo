package com.example.Labo.business.dto;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@ToString
public class UtilisateurDTO implements IdentifiedDTO<Integer>{

    private Integer id;

    @Size(min = 4, max = 20)
    private String username;

    @NotBlank
    @Size(min = 6)
    private String password;

    @NotEmpty
    @Size(max = 50)
    private String nom;

    @NotEmpty
    @Size(max = 50)
    private String prenom;

    @NotBlank
    @Email
    private String email;
}
