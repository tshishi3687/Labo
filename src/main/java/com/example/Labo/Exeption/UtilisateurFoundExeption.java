package com.example.Labo.Exeption;

import com.example.Labo.business.dto.UtilisateurDTO;

public class UtilisateurFoundExeption extends FoundExeption{
    public UtilisateurFoundExeption(int id) {
        super(UtilisateurDTO.class, id);
    }
}
