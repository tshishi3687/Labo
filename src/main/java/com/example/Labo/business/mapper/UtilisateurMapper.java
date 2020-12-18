package com.example.Labo.business.mapper;

import com.example.Labo.business.dto.UtilisateurDTO;
import com.example.Labo.data_access.entity.Utilisateur;
import org.springframework.stereotype.Component;

@Component
public class UtilisateurMapper implements Mapper<UtilisateurDTO, Utilisateur>{
    @Override
    public UtilisateurDTO toDTO(Utilisateur utilisateur) {
        if (utilisateur == null)
            return null;

        return new UtilisateurDTO(
                utilisateur.getId(),
                utilisateur.getUsername(),
                utilisateur.getPassword(),
                utilisateur.getNom(),
                utilisateur.getPrenom(),
                utilisateur.getEmail()
        );
    }

    @Override
    public Utilisateur toEntity(UtilisateurDTO utilisateurDTO) {
        if (utilisateurDTO == null)
            return null;

        Utilisateur utilisateur = new Utilisateur();
            utilisateur.setId(utilisateurDTO.getId());
            utilisateur.setUsername(utilisateurDTO.getUsername());
            utilisateur.setPassword(utilisateurDTO.getPassword());
            utilisateur.setNom(utilisateurDTO.getNom());
            utilisateur.setPrenom(utilisateurDTO.getPrenom());
            utilisateur.setEmail(utilisateurDTO.getEmail());

            return utilisateur;
    }
}
