package fr.sparks.plage.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import fr.sparks.plage.validator.DateDebutAvantDateFinValidator;

@Target({ ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DateDebutAvantDateFinValidator.class)
@Documented
public @interface DateDebutAvantDateFin {

	String message() default "La date de début doit être antérieure à la date de fin";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
