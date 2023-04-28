package fr.sparks.plage.business;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@EqualsAndHashCode(callSuper = true)
@Data
public class Concessionnaire extends Utilisateur {

	private String numeroDeTelephone;
}
