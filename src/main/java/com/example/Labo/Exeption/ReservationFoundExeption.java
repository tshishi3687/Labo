package com.example.Labo.Exeption;

import com.example.Labo.business.dto.ReservationDTO;

public class ReservationFoundExeption extends FoundExeption{
    public ReservationFoundExeption(int id){super(ReservationDTO.class, id);}
}
