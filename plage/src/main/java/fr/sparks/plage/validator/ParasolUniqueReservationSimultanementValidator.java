package fr.sparks.plage.validator;

import fr.sparks.plage.annotation.ParasolUniqueReservationSimultanement;
import fr.sparks.plage.entity.Parasol;
import fr.sparks.plage.entity.Reservation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ParasolUniqueReservationSimultanementValidator implements ConstraintValidator<ParasolUniqueReservationSimultanement, Parasol> {

    @Override
    public boolean isValid(Parasol parasol, ConstraintValidatorContext constraintValidatorContext) {
        boolean isValid=false;
        for (Reservation r : parasol.getReservations()){
            for(Reservation r2 : parasol.getReservations()) {
                isValid= r.getDateFin().isBefore(r2.getDateDebut()) && r.getDateFin().isAfter(r2.getDateDebut());
            }
        }
        return isValid;
    }
}
