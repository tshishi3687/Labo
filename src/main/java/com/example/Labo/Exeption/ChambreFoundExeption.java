package com.example.Labo.Exeption;

import com.example.Labo.business.dto.ChambreDTO;

public class ChambreFoundExeption extends FoundExeption{
    public ChambreFoundExeption(int id) {
        super(ChambreDTO.class, id);
    }
}
