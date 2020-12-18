package com.example.Labo.business.service;

import com.example.Labo.Exeption.*;
import com.example.Labo.business.dto.UtilisateurDTO;
import com.example.Labo.business.mapper.Mapper;
import com.example.Labo.data_access.entity.Utilisateur;
import com.example.Labo.data_access.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UtilisateurService implements CrudService<UtilisateurDTO, Integer>{

    @Autowired
    private Mapper<UtilisateurDTO, Utilisateur> mapper;
    @Autowired
    private UtilisateurRepository repository;

    @Override
    public void creat(UtilisateurDTO toCreat) throws ElementAlreadyExistsException {
        if (repository.existsById(toCreat.getId()))
            throw new UtilisateurExisteExeption(toCreat.getId());

        repository.save(mapper.toEntity(toCreat));
    }

    @Override
    public UtilisateurDTO readOne(Integer integer) throws FoundExeption {
        Utilisateur entity = repository.findById(integer)
                .orElseThrow(()-> new UtilisateurFoundExeption(integer));

        return mapper.toDTO(entity);
    }

    @Override
    public List<UtilisateurDTO> readAll() {
        return repository.findAll().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void update(UtilisateurDTO toUpdate) throws FoundExeption {
        if( !repository.existsById( toUpdate.getId() ))
            throw new UtilisateurFoundExeption(toUpdate.getId());

        repository.save( mapper.toEntity(toUpdate) );
    }

    @Override
    public void delete(Integer toDelete) throws FoundExeption {
        if( !repository.existsById(toDelete))
            throw new UtilisateurFoundExeption(toDelete);

        repository.deleteById(toDelete);
    }
}
