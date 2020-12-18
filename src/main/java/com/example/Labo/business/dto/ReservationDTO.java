package com.example.Labo.business.dto;

import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@ToString
public class ReservationDTO implements IdentifiedDTO<Integer>{

    @Getter @Setter
    private Integer id;

    @Getter
    private Integer nPersonne;

    @NotEmpty
    @Valid
    @Getter
    private LocalDate dateArrivee;

    @NotEmpty
    @Valid
    @Getter
    private LocalDate dateDepart;

    @Getter @Setter
    private UtilisateurSimpleDTO reserve;

    @Getter @Setter
    private ChambreDTO estReservee;


    @Valid
    public void setDateArrivee(LocalDate dateArrivee) {
        if (dateArrivee.getDayOfMonth()>LocalDate.now().getDayOfMonth())
            this.dateArrivee = dateArrivee;
    }

    @Valid
    public void setDateDepart(LocalDate dateDepart) {
        if (dateDepart.getDayOfMonth()<=getDateArrivee().getDayOfMonth())
            this.dateDepart = dateDepart;
    }

    public void setnPersonne(Integer nPersonne) {
        if (nPersonne<= getEstReservee().getPlace())
            this.nPersonne = nPersonne;
    }
}
