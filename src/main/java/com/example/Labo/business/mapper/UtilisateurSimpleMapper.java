package com.example.Labo.business.mapper;

import com.example.Labo.business.dto.UtilisateurSimpleDTO;
import com.example.Labo.data_access.entity.Utilisateur;
import org.springframework.stereotype.Component;

@Component
public class UtilisateurSimpleMapper implements Mapper<UtilisateurSimpleDTO, Utilisateur>{

private Utilisateur uti = new Utilisateur();
    @Override
    public UtilisateurSimpleDTO toDTO(Utilisateur utilisateur) {
        if (utilisateur == null)
            return null;

        return new UtilisateurSimpleDTO(
                utilisateur.getId()

        );
    }

    @Override
    public Utilisateur toEntity(UtilisateurSimpleDTO utilisateurSimpleDTO) {
        if (utilisateurSimpleDTO == null)
            return null;

        Utilisateur utilisateur = new Utilisateur();
            utilisateur.setId(utilisateurSimpleDTO.getId());

            return utilisateur;
    }
}
