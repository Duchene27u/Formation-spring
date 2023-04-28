package fr.sparks.plage.business;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Pays {

	@Id
	@NonNull
	private String code;

	@NonNull
	@NotBlank(message="Merci de préciser le nom du pays")
	private String nom;
	
	// au moment où Hibernate récupère un pays, il va immédiatement
	// alimenter la liste des clients de ce pays si la valeur du fetch est EAGER
	@OneToMany(mappedBy="pays", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	@JsonIgnore
	@ToString.Exclude
	private List<Client> clients;

}
