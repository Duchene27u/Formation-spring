package fr.sparks.plage.business;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.CreditCardNumber;

import fr.sparks.plage.annotation.DateDebutAvantDateFin;
import lombok.Data;

@Entity
@Data
@DateDebutAvantDateFin
public class Reservation {

	@Id
	@GeneratedValue
	protected Long id;
	
	private LocalDate dateDebut;
	
	private LocalDate dateFin;
	
	private double montantAReglerEnEuros;
	
	private String remarques;
	
	@CreditCardNumber(message="Le numéro de votre carte est invalide")
	private String numeroCarte;
	
	private byte moisExpiration;
	
	private byte anneeExpiration;
	
	@Size(min=3, max=3, message="Le cryptogramme est formé de {min} caractères")
	private String cryptogramme;
	
	@ManyToOne
	private Client client;
	
	@ManyToMany
	@Size(min=1)
	private List<Parasol> parasols;
	
	@ManyToOne
	private Statut statut;
	
	@ManyToOne
	private Concessionnaire concessionnaire;
}
