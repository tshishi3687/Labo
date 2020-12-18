package com.example.Labo.rest_api;

import com.example.Labo.business.dto.ChambreDTO;
import com.example.Labo.business.dto.ChambreInfoDTO;
import com.example.Labo.business.service.CrudService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("chambre")
public class ChambreController extends AbstractCrudController<ChambreDTO, Integer>{

    public ChambreController(CrudService<ChambreDTO, Integer> service) {
        super(service);
    }


}
