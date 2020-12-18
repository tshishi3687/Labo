package com.example.Labo.mesTest;

import com.example.Labo.Exeption.ElementAlreadyExistsException;
import com.example.Labo.Exeption.FoundExeption;
import com.example.Labo.business.dto.ActiviteeDTO;
import com.example.Labo.business.dto.ChambreDTO;
import com.example.Labo.business.dto.UtilisateurSimpleDTO;
import com.example.Labo.business.service.ActiviteeService;
import com.example.Labo.business.service.ChambreService;
import com.example.Labo.data_access.entity.Activitee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@ComponentScan("com.example.Labo")
public class Chambretest {

    public static void main(String[] args) throws ElementAlreadyExistsException {

        ApplicationContext ctx = SpringApplication.run(Chambretest.class, args);
        ChambreService act = ctx.getBean(ChambreService.class);
        ActiviteeService activiteeService = ctx.getBean(ActiviteeService.class);

        UtilisateurSimpleDTO ut = new UtilisateurSimpleDTO(
                1
        );

        ActiviteeDTO dto = new ActiviteeDTO(
                1,
                "La pêche aux chiens",
                "Wouf wOuf"

        );
        List<ActiviteeDTO> activiteeList = new ArrayList<>();
        activiteeList.add(dto);

        ChambreDTO cha = new ChambreDTO(
                0,
                "tytyt",
                "totot",
                3,
                ut, activiteeList

        );

        System.out.println(act.readByActivitee(1));


        // test Creat
//        act.creat(cha); ok

        // test readOne - ok
//        try{
//			System.out.println( act.readOne(3) );
//		}
//		catch (FoundExeption e){
//			System.out.println(e.getMessage());
//		}

        // test update - V

//		try{
//			act.update( cha );
//		}
//		catch (FoundExeption e){
//			System.out.println( e.getMessage() );
//		}

//        // test delete -

//        try{
//            act.delete(5555);
//        }
//        catch (FoundExeption e)
//        {
//            System.out.println(e.getMessage());
//        }

    }
}
