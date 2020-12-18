package com.example.Labo.Exeption;

import com.example.Labo.business.dto.ChambreDTO;

public class ChambreExisteExeption extends ElementAlreadyExistsException{

    public ChambreExisteExeption(int id) {
        super( id, ChambreDTO.class);
    }
}
