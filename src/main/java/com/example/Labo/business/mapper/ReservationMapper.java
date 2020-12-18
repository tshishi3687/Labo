package com.example.Labo.business.mapper;

import com.example.Labo.business.dto.ChambreDTO;
import com.example.Labo.business.dto.ReservationDTO;
import com.example.Labo.business.dto.UtilisateurSimpleDTO;
import com.example.Labo.data_access.entity.Chambre;
import com.example.Labo.data_access.entity.Reservation;
import com.example.Labo.data_access.entity.Utilisateur;
import com.example.Labo.data_access.repository.ChambreRepository;
import com.example.Labo.data_access.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReservationMapper implements Mapper<ReservationDTO, Reservation>{

    @Autowired
    private Mapper<UtilisateurSimpleDTO, Utilisateur> utilisateurMapper;
    @Autowired
    private Mapper<ChambreDTO, Chambre> chambreMapper;
    @Autowired
    private UtilisateurRepository repositoryUtilisateur;
    @Autowired
    private ChambreRepository repositoryChambre;

    @Override
    public ReservationDTO toDTO(Reservation reservation) {
        if (reservation == null)
            return null;

        return new ReservationDTO(
                reservation.getId(),
                reservation.getNPersonne(),
                reservation.getDateArrivee(),
                reservation.getDateDepart(),
                utilisateurMapper.toDTO(reservation.getReserve()),
                chambreMapper.toDTO(reservation.getEstReservee())
        );
    }

    @Override
    public Reservation toEntity(ReservationDTO reservationDTO) {
        if (reservationDTO == null)
            return null;

        Reservation reservation = new Reservation();
        reservation.setId(reservationDTO.getId());
        reservation.setNPersonne(reservationDTO.getNPersonne());
        reservation.setDateArrivee(reservationDTO.getDateArrivee());
        reservation.setDateDepart(reservationDTO.getDateDepart());
        reservation.setReserve(repositoryUtilisateur.getOne(reservationDTO.getReserve().getId()));
        reservation.setEstReservee(repositoryChambre.getOne(reservationDTO.getEstReservee().getId()));

        return reservation;
    }
}
