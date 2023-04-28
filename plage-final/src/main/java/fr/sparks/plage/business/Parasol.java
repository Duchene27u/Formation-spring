package fr.sparks.plage.business;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
public class Parasol {

	@Id
	@GeneratedValue
	private Long id;
	
	private byte numEmplacement;
	
	// On fait référence à un parasol
	// Un parsol se trouve dans une seule file
	@ManyToOne
	private File file;
	
	@ToString.Exclude
	@ManyToMany(mappedBy="parasols")
	private List<Reservation> reservations;

	public Parasol(byte numEmplacement, File file) {
		super();
		this.numEmplacement = numEmplacement;
		this.file = file;
	}
	
}
