package com.example.Labo.Exeption;

import com.example.Labo.business.dto.ActiviteeDTO;

public class ActiviteeFoundExeption extends FoundExeption{
    public ActiviteeFoundExeption(int id) {
        super(ActiviteeDTO.class, id);
    }
}
