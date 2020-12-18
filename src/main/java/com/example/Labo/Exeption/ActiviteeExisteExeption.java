package com.example.Labo.Exeption;

import com.example.Labo.business.dto.ActiviteeDTO;

public class ActiviteeExisteExeption extends ElementAlreadyExistsException{

    public ActiviteeExisteExeption(int id) {
        super( id, ActiviteeDTO.class);
    }
}
