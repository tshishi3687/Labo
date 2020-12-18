package com.example.Labo.data_access.repository;

import com.example.Labo.data_access.entity.Reservation;
import com.example.Labo.data_access.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

    List<Reservation> findByReserve(Utilisateur utilisateur);
    // select * from reservation where utilisateur.id=?

    List<Reservation> findByEstReservee_Geree(Utilisateur utilisateur);
    // select * from reservation
        // join chambre
            // on reservation.estReservee = chambre.id
        // where chambre.geree = ?
}
