package com.example.Labo.business.mapper;

import com.example.Labo.business.dto.ActiviteeDTO;
import com.example.Labo.data_access.entity.Activitee;
import org.springframework.stereotype.Component;

@Component
public class ActiviteeMapper implements Mapper<ActiviteeDTO, Activitee>{
    @Override
    public ActiviteeDTO toDTO(Activitee activitee) {
        if (activitee == null)
            return null;

        return new ActiviteeDTO(
                activitee.getId(),
                activitee.getNom(),
                activitee.getDesc()
        );
    }

    @Override
    public Activitee toEntity(ActiviteeDTO activiteeDTO) {
        if (activiteeDTO == null)
            return null;

        return new Activitee(
                activiteeDTO.getId(),
                activiteeDTO.getNom(),
                activiteeDTO.getDesc()
        );
    }
}
