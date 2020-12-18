package com.example.Labo.business.service;

import com.example.Labo.Exeption.ElementAlreadyExistsException;
import com.example.Labo.Exeption.FoundExeption;

import java.util.List;

public interface CrudService <DTO,ID>{

    // creat
    void creat(DTO toCreat) throws ElementAlreadyExistsException ;

    // Read
    DTO readOne(ID id) throws FoundExeption;
    List<DTO> readAll();

    // update
    void update(DTO toUpdate) throws FoundExeption;

    // delete
    void delete(ID toDelete) throws FoundExeption;
}
