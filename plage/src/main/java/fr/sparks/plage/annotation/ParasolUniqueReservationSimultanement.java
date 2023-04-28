package fr.sparks.plage.annotation;

import fr.sparks.plage.validator.ParasolUniqueReservationSimultanementValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.TYPE})
@Constraint(validatedBy = { ParasolUniqueReservationSimultanementValidator.class })
@Retention(RetentionPolicy.RUNTIME)
public @interface ParasolUniqueReservationSimultanement {

    String message() default "Un parasol ne peut pas avoir 2 réservations simultanés";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
