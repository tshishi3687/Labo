package com.example.Labo.rest_api.edviser;

import com.example.Labo.Exeption.ElementAlreadyExistsException;
import com.example.Labo.Exeption.ElementFoundException;
import com.example.Labo.rest_api.model.raport.ExistsRaport;
import com.example.Labo.rest_api.model.raport.FoundRaport;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdviser {

   @ExceptionHandler(ElementAlreadyExistsException.class)
    public ResponseEntity<ExistsRaport> elementAlreadyExistsHandler(ElementAlreadyExistsException ex){
       ExistsRaport raport = new ExistsRaport(ex.getId(),ex.getClazz().getSimpleName());
       return ResponseEntity.badRequest().body(raport);
   }

    @ExceptionHandler(ElementFoundException.class)
    public ResponseEntity<FoundRaport> elementNotFoundHandler(ElementFoundException ex )
    {
        FoundRaport report = new FoundRaport(ex.getId(), ex.getClazz().getSimpleName());
        return ResponseEntity.badRequest().body(report);
    }

}
