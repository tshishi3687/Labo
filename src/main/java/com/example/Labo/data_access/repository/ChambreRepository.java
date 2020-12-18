package com.example.Labo.data_access.repository;

import com.example.Labo.business.dto.ChambreInfoDTO;
import com.example.Labo.data_access.entity.Activitee;
import com.example.Labo.data_access.entity.Chambre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChambreRepository extends JpaRepository<Chambre, Integer> {

        List<Chambre> findByActivite(Activitee activite);
        // select * fron chambre where activitee.id = ?

}
