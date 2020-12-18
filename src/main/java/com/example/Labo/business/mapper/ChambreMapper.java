package com.example.Labo.business.mapper;

import com.example.Labo.business.dto.ActiviteeDTO;
import com.example.Labo.business.dto.ChambreDTO;
import com.example.Labo.business.dto.UtilisateurSimpleDTO;
import com.example.Labo.data_access.entity.Activitee;
import com.example.Labo.data_access.entity.Chambre;
import com.example.Labo.data_access.entity.Utilisateur;
import com.example.Labo.data_access.repository.ActiviteeRepository;
import com.example.Labo.data_access.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class ChambreMapper implements Mapper<ChambreDTO, Chambre>{

    @Autowired
    private Mapper<UtilisateurSimpleDTO, Utilisateur> utilisateurMapper;
    @Autowired
    private Mapper<ActiviteeDTO, Activitee> activiteeMapper;
    @Autowired
    private UtilisateurRepository repository;
    @Autowired
    private ActiviteeRepository activiteeRepository;

    @Override
    public ChambreDTO toDTO(Chambre chambre) {
        if (chambre == null)
            return null;

        return new ChambreDTO(
                chambre.getId(),
                chambre.getAdresse(),
                chambre.getVille(),
                chambre.getPlace(),
                utilisateurMapper.toDTO(chambre.getGeree()),
                chambre.getActivite().stream()
                        .map((activitee -> activiteeMapper.toDTO(activitee)))
                .collect(Collectors.toList())
        );
    }

    @Override
    public Chambre toEntity(ChambreDTO chambreDTO) {
        if (chambreDTO == null)
            return null;

        Chambre chambre = new Chambre();
        chambre.setId(chambreDTO.getId());
        chambre.setAdresse(chambreDTO.getAdresse());
        chambre.setVille(chambreDTO.getVille());
        chambre.setPlace(chambreDTO.getPlace());
        chambre.setGeree(repository.getOne(chambreDTO.getGeree().getId()));
        chambre.setActivite(activiteeRepository.findAllById(chambreDTO.getActivite().stream()
                .map(activiteeDTO -> activiteeDTO.getId())
                .collect(Collectors.toList())))
        ;

        return chambre;
    }
}
