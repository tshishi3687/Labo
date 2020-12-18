package com.example.Labo.rest_api;

import com.example.Labo.business.dto.ActiviteeDTO;
import com.example.Labo.business.dto.ReservationDTO;
import com.example.Labo.business.service.CrudService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("reservation")
public class ReservationController extends AbstractCrudController<ReservationDTO, Integer>{

    public ReservationController(CrudService<ReservationDTO, Integer> service) {
        super(service);
    }
}
