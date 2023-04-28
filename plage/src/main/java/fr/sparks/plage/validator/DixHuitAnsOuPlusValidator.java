package fr.sparks.plage.validator;

import fr.sparks.plage.annotation.DixHuitAnsOuPlus;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.YEARS;

public class DixHuitAnsOuPlusValidator implements ConstraintValidator<DixHuitAnsOuPlus, LocalDate> {

    @Override
    public boolean isValid(LocalDate dateNaissance, ConstraintValidatorContext context) {
        return dateNaissance != null && YEARS.between(dateNaissance, LocalDate.now())>=18;
    }
}
