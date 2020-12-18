package com.example.Labo.business.service;

import com.example.Labo.Exeption.ActiviteeExisteExeption;
import com.example.Labo.Exeption.ActiviteeFoundExeption;
import com.example.Labo.Exeption.ElementAlreadyExistsException;
import com.example.Labo.Exeption.FoundExeption;
import com.example.Labo.business.dto.ActiviteeDTO;
import com.example.Labo.business.dto.ChambreDTO;
import com.example.Labo.business.dto.ReservationDTO;
import com.example.Labo.business.mapper.Mapper;
import com.example.Labo.data_access.entity.Activitee;
import com.example.Labo.data_access.repository.ActiviteeRepository;
import com.example.Labo.data_access.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActiviteeService implements CrudService<ActiviteeDTO, Integer>{

    @Autowired
    private Mapper<ActiviteeDTO, Activitee> mapper;
    @Autowired
    private ActiviteeRepository repository;

    @Override
    public void creat(ActiviteeDTO toCreat) throws ElementAlreadyExistsException {
        if(repository.existsById(toCreat.getId()))
            throw new ActiviteeExisteExeption(toCreat.getId());

        repository.save(mapper.toEntity(toCreat));
    }

    @Override
    public ActiviteeDTO readOne(Integer integer) throws FoundExeption {
        Activitee entity = repository.findById(integer)
                .orElseThrow(()-> new ActiviteeFoundExeption(integer));

        return mapper.toDTO(entity);
    }

    @Override
    public List<ActiviteeDTO> readAll() {
        return repository.findAll().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void update(ActiviteeDTO toUpdate) throws FoundExeption {
        if( !repository.existsById( toUpdate.getId() ))
            throw new ActiviteeFoundExeption(toUpdate.getId());

        repository.save( mapper.toEntity(toUpdate) );
    }

    @Override
    public void delete(Integer toDelete) throws FoundExeption {
        if( !repository.existsById(toDelete))
            throw new ActiviteeFoundExeption(toDelete);

        repository.deleteById(toDelete);
    }
}
