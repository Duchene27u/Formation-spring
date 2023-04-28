package fr.sparks.plage.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ClientDto {

	Long id;
	
	private LocalDateTime dateHeureInscription;

	String nom;
	
	String prenom;
	
	String email;

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	String motDePasse;
	
	PaysDto paysDto;
	
}
