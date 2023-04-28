package fr.sparks.plage.annotation;

import fr.sparks.plage.validator.DateDebutAvantDateFinValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.TYPE})
@Constraint(validatedBy = { DateDebutAvantDateFinValidator.class })
@Retention(RetentionPolicy.RUNTIME)
public @interface DateDebutAvantDateFin {

    String message() default "La date de début de réservation doit être avant la date de fin de réservation";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
