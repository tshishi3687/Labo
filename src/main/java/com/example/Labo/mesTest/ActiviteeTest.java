package com.example.Labo.mesTest;

import com.example.Labo.Exeption.*;
import com.example.Labo.business.dto.ActiviteeDTO;
import com.example.Labo.business.service.ActiviteeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ActiviteeTest {

    public static void main(String[] args) throws ElementAlreadyExistsException {

        ApplicationContext ctx = SpringApplication.run(ActiviteeTest.class, args);
        ActiviteeService act = ctx.getBean(ActiviteeService.class);

        ActiviteeDTO dto = new ActiviteeDTO(
                3,
                "La pêche aux chiens",
                "Wouf wOuf"

        );

        // test Creat
//        act.creat(dto); ok

        // test readOne - ok
//        try{
//			System.out.println( act.readOne(3) );
//		}
//		catch (FoundExeption e){
//			System.out.println(e.getMessage());
//		}

        // test update - V

//		try{
//			act.update( dto );
//		}
//		catch (FoundExeption e){
//			System.out.println( e.getMessage() );
//		}

//        // test delete -

        try{
            act.delete(5555);
        }
        catch (FoundExeption e)
        {
            System.out.println(e.getMessage());
        }
    }
}
