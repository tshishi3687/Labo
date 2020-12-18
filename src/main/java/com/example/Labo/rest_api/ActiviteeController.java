package com.example.Labo.rest_api;

import com.example.Labo.business.dto.ActiviteeDTO;
import com.example.Labo.business.service.CrudService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("activitee")
public class ActiviteeController extends AbstractCrudController<ActiviteeDTO, Integer>{

    public ActiviteeController(CrudService<ActiviteeDTO, Integer> service) {
        super(service);
    }
}
