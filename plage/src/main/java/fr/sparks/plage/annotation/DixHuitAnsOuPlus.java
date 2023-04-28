package fr.sparks.plage.annotation;

import fr.sparks.plage.validator.DixHuitAnsOuPlusValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.FIELD, ElementType.METHOD})
@Constraint(validatedBy = { DixHuitAnsOuPlusValidator.class })
@Retention(RetentionPolicy.RUNTIME)
public @interface DixHuitAnsOuPlus {

    String message() default "Vous devez avoir au moins 18 ans";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
