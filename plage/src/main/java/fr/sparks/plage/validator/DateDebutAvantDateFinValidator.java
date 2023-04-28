package fr.sparks.plage.validator;

import fr.sparks.plage.annotation.DateDebutAvantDateFin;
import fr.sparks.plage.entity.Reservation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DateDebutAvantDateFinValidator implements ConstraintValidator<DateDebutAvantDateFin, Reservation> {

    @Override
    public boolean isValid(Reservation reservation, ConstraintValidatorContext context) {
        return reservation.getDateDebut().isBefore(reservation.getDateFin());
    }
}
