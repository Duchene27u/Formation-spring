package fr.sparks.plage.business;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class LienDeParente {

	@Id
	@GeneratedValue
	private Long id;
	
	private String nom;
	
	private float coefficient;

	public LienDeParente(String nom, float coefficient) {
		super();
		this.nom = nom;
		this.coefficient = coefficient;
	}
	
	
}
