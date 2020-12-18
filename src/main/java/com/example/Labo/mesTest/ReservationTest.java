package com.example.Labo.mesTest;

import com.example.Labo.Exeption.ElementAlreadyExistsException;
import com.example.Labo.business.dto.ChambreDTO;
import com.example.Labo.business.dto.ReservationDTO;
import com.example.Labo.business.dto.UtilisateurSimpleDTO;
import com.example.Labo.business.service.ReservationService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;

@SpringBootApplication
public class ReservationTest {

    public static void main(String[] args) throws ElementAlreadyExistsException {

        ApplicationContext ctx = SpringApplication.run(ReservationTest.class, args);
        ReservationService act = ctx.getBean(ReservationService.class);

        UtilisateurSimpleDTO ut = new UtilisateurSimpleDTO(
                1
        );


        System.out.println(act.readWithUtilisateur(ut.getId()));

//        ChambreDTO cha = new ChambreDTO(
//                1,
//                "Rue de la mort",
//                "Creuvar-Sur-Mer",
//                3,
//                ut
//        );

//        ReservationDTO reserv = new ReservationDTO(
//                0,
//                5,
//                LocalDate.of(1987,06,03),
//                LocalDate.of(1987,06,03),
//                ut,
//                cha
//
//        );
//        // test Creat
//        act.creat(reserv);
    }
}
