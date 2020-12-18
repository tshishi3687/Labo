package com.example.Labo.business.service;

import com.example.Labo.Exeption.*;
import com.example.Labo.business.dto.ChambreDTO;
import com.example.Labo.business.mapper.Mapper;
import com.example.Labo.data_access.entity.Activitee;
import com.example.Labo.data_access.entity.Chambre;
import com.example.Labo.data_access.repository.ActiviteeRepository;
import com.example.Labo.data_access.repository.ChambreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChambreService implements CrudService<ChambreDTO, Integer>{

    @Autowired
    private Mapper<ChambreDTO, Chambre> mapper;
    @Autowired
    private ChambreRepository repository;
    @Autowired
    private ActiviteeRepository activiteeRepository;

    @Override
    public void creat(ChambreDTO toCreat) throws ElementAlreadyExistsException {
        if(repository.existsById(toCreat.getId()))
            throw new ChambreExisteExeption(toCreat.getId());

        repository.save(mapper.toEntity(toCreat));
    }

    @Override
    public ChambreDTO readOne(Integer integer) throws FoundExeption {
        Chambre entity = repository.findById(integer)
                .orElseThrow(()-> new ChambreFoundExeption(integer));

        return mapper.toDTO(entity);
    }

    @Override
    public List<ChambreDTO> readAll() {
        return repository.findAll().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void update(ChambreDTO toUpdate) throws FoundExeption {
        if( !repository.existsById( toUpdate.getId() ))
        throw new ChambreFoundExeption(toUpdate.getId());

        repository.save( mapper.toEntity(toUpdate) );
    }

    @Override
    public void delete(Integer toDelete) throws FoundExeption {
        if( !repository.existsById(toDelete))
            throw new ChambreFoundExeption(toDelete);

        repository.deleteById(toDelete);
    }

    @Transactional
    public List<ChambreDTO> readByActivitee(Integer integer){
        return repository.findByActivite(activiteeRepository.getOne(integer))
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }
}
