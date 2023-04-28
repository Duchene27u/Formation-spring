package fr.sparks.plage.service;

import java.util.List;

import fr.sparks.plage.business.Pays;
import fr.sparks.plage.dto.PaysDto;

public interface PaysService {

	Pays ajouterPays(PaysDto paysDto);
	
	Pays ajouterPays(String code, String nom);

	Pays enregistrerPays(Pays pays);
	
	Pays enregistrerPays(PaysDto paysDto);

	List<Pays> recupererPays();

	Pays recupererPays(String code);
	

	Pays mettreAJour(String code, String nouveauNom);
	
	boolean supprimerPays(String code);



}
