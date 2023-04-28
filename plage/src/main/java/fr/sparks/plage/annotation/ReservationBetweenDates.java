package fr.sparks.plage.annotation;

import fr.sparks.plage.validator.ReservationBetweenDatesValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.TYPE})
@Constraint(validatedBy = { ReservationBetweenDatesValidator.class })
@Retention(RetentionPolicy.RUNTIME)
public @interface ReservationBetweenDates {

    String message() default "La réservation doit être faite entre le 1er juin et le 15 septembre";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
