package fr.sparks.plage.validator;

import static java.time.temporal.ChronoUnit.YEARS;

import java.time.LocalDate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import fr.sparks.plage.annotation.DixHuitAnsOuPlus;

public class DixHuitAnsOuPlusValidator implements ConstraintValidator<DixHuitAnsOuPlus, LocalDate>{

	@Override
	
	public boolean isValid(LocalDate dateDeNaissance, ConstraintValidatorContext context) {
		return dateDeNaissance!=null && YEARS.between(dateDeNaissance, LocalDate.now())>=18;
	}

}
