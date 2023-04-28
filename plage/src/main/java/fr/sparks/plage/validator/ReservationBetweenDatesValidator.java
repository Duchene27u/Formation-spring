package fr.sparks.plage.validator;

import fr.sparks.plage.annotation.ReservationBetweenDates;
import fr.sparks.plage.entity.Reservation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class ReservationBetweenDatesValidator implements ConstraintValidator<ReservationBetweenDates, Reservation> {

    @Override
    public boolean isValid(Reservation reservation, ConstraintValidatorContext constraintValidatorContext) {
        return verifierDateDebutApres1erJuin(reservation.getDateDebut()) && verifierDateFinAvant15Septembre(reservation.getDateFin());
    }

    private boolean verifierDateDebutApres1erJuin(LocalDate dateDebut) {
        return dateDebut.getMonth().getValue() >= 6;
    }

    private boolean verifierDateFinAvant15Septembre(LocalDate dateFin){
        return dateFin.isBefore(LocalDate.of(dateFin.getYear(), 9,16));
    }
}
