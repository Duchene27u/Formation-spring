package fr.sparks.plage.business;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@NoArgsConstructor
@SuperBuilder
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Utilisateur {

	@Id
	@GeneratedValue
	protected Long id;
	
	@NotBlank(message="Merci de préciser votre nom")
	protected String nom;
	
	protected String prenom;
	
	@Email(message="Votre email n''est pas valide")
	protected String email;
	
	@Size(min=8, message="Votre mot de passe doit contenir {min} caractères")
	protected String motDePasse; 
}
