package com.example.Labo.business.service;

import com.example.Labo.Exeption.*;
import com.example.Labo.business.dto.ReservationDTO;
import com.example.Labo.business.mapper.Mapper;
import com.example.Labo.data_access.entity.Reservation;
import com.example.Labo.data_access.repository.ReservationRepository;
import com.example.Labo.data_access.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationService implements CrudService<ReservationDTO, Integer>{

    @Autowired
    private Mapper<ReservationDTO, Reservation> mapper;
    @Autowired
    private ReservationRepository repository;
    @Autowired
    private UtilisateurRepository utilisateurRepository;


    @Override
    public void creat(ReservationDTO toCreat) throws ElementAlreadyExistsException {
        if(repository.existsById(toCreat.getId()))
            throw new ReservationExisteExeption(toCreat.getId());

        repository.save(mapper.toEntity(toCreat));
    }

    @Override
    public ReservationDTO readOne(Integer integer) throws FoundExeption {
        Reservation entity = repository.findById(integer)
                .orElseThrow(()-> new ReservationFoundExeption(integer));

        return mapper.toDTO(entity);
    }

    @Override
    public List<ReservationDTO> readAll() {
        return repository.findAll().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void update(ReservationDTO toUpdate) throws FoundExeption {
        if( !repository.existsById( toUpdate.getId() ))
            throw new ReservationFoundExeption(toUpdate.getId());

        repository.save( mapper.toEntity(toUpdate) );
    }

    @Override
    public void delete(Integer toDelete) throws FoundExeption {
        if( !repository.existsById(toDelete))
            throw new ReservationFoundExeption(toDelete);

        repository.deleteById(toDelete);
    }

    @Transactional
    public List<ReservationDTO> readByUtilisateur(Integer integer){
        return repository.findByReserve(utilisateurRepository.getOne(integer))
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public List<ReservationDTO> readWithUtilisateur(Integer integer){
        return repository.findByEstReservee_Geree(utilisateurRepository.getOne(integer))
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }
}
