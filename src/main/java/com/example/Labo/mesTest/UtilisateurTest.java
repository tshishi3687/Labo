package com.example.Labo.mesTest;

import com.example.Labo.Exeption.ElementAlreadyExistsException;
import com.example.Labo.business.dto.UtilisateurDTO;
import com.example.Labo.business.service.UtilisateurService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class UtilisateurTest {

    public static void main(String[] args) throws ElementAlreadyExistsException {

        ApplicationContext ctx = SpringApplication.run(UtilisateurTest.class, args);
        UtilisateurService us = ctx.getBean(UtilisateurService.class);

        UtilisateurDTO utilisateur = new UtilisateurDTO(
                0,
                "tshishi",
                "BeauGoss4451",
                "Tshibangu",
                "Cédrick",
                "1254@5678.90"
        );


        // test Creat ok
        us.creat(utilisateur);

//         test readOne - ok
//        try{
//			System.out.println( us.readOne(3) );
//		}
//		catch (FoundExeption e){
//			System.out.println(e.getMessage());
//		}

        // test update - V

//		try{
//			us.update( utilisateur );
//		}
//		catch (FoundExeption e){
//			System.out.println( e.getMessage() );
//		}

//        // test delete -

//        try{
//            us.delete(5555);
//        }
//        catch (FoundExeption e)
//        {
//            System.out.println(e.getMessage());
//        }
    }
}
