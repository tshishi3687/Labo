package com.example.Labo.rest_api;

import com.example.Labo.business.dto.ActiviteeDTO;
import com.example.Labo.business.dto.UtilisateurDTO;
import com.example.Labo.business.service.CrudService;
import com.example.Labo.rest_api.AbstractCrudController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("utilisateur")
public class UtilisateurController extends AbstractCrudController<UtilisateurDTO, Integer> {

    public UtilisateurController(CrudService<UtilisateurDTO, Integer> service) {
        super(service);
    }


}
