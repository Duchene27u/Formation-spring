package fr.sparks.plage.business;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.Range;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity // Annotation qui fait partie de la specification JPA (Java Persistence API)
@Data
@NoArgsConstructor
public class File {

	@Id
	@GeneratedValue
	private Long id;
	
	private byte numero;
	
	@Range(min=5, max=20, message="Le prix journalier doit être compris entre {min} et {max} euros")
	private double prixJournalier;
	
	@ToString.Exclude
	@OneToMany(mappedBy="file")
	// Les parasols de cette file
	private List<Parasol> parasols;
	
	public File(byte numero, double prixJournalier) {
		super();
		this.numero = numero;
		this.prixJournalier = prixJournalier;
	}
	
	
}
