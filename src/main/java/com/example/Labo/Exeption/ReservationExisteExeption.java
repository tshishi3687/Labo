package com.example.Labo.Exeption;

import com.example.Labo.business.dto.ReservationDTO;

public class ReservationExisteExeption extends ElementAlreadyExistsException{
    public ReservationExisteExeption(int id) {
        super( id, ReservationDTO.class);
    }
}
