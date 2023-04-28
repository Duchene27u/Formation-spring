package fr.sparks.plage.service;

import fr.sparks.plage.dto.PaysDto;
import fr.sparks.plage.entity.Pays;

import java.util.List;

public interface PaysService {

	Pays enregistrerPays(String code, String nom);

	Pays enregistrerPays(Pays pays);
	
	Pays enregistrerPays(PaysDto paysDto);

	List<Pays> recupererPays();

	Pays recupererPays(String code);
	

	Pays mettreAJour(String code, String nouveauNom);
	
	boolean supprimerPays(String code);


}
