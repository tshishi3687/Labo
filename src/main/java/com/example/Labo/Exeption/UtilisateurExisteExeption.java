package com.example.Labo.Exeption;

import com.example.Labo.business.dto.ActiviteeDTO;

public class UtilisateurExisteExeption extends ElementAlreadyExistsException {
    public UtilisateurExisteExeption(int id) {
        super( id, ActiviteeDTO.class);
    }
}
