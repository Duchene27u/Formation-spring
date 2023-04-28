package fr.sparks.plage.business;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import fr.sparks.plage.annotation.DixHuitAnsOuPlus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
public class Client extends Utilisateur {

	@Builder.Default
	private LocalDateTime dateHeureInscription = LocalDateTime.now();
	
	@ManyToOne
	@NotNull(message="Merci de renseigner votre pays")
	private Pays pays;
	
	@ManyToOne
	//@NotNull(message="Merci de renseigner votre lien de parenté")
	private LienDeParente lienDeParente;
	
	@OneToMany(mappedBy="client")
	@ToString.Exclude
	private List<Reservation> reservations;
	
	@NotNull(message="Merci de préciser une date de naissance")
	@DixHuitAnsOuPlus
	private LocalDate dateDeNaissance;
}
