package fr.sparks.plage.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.sparks.plage.business.Pays;

public interface PaysDao extends JpaRepository<Pays, String> {
	
	// Méthode qui renvoie les pays pour lesquels nous n'avons pas encore de clients
	List<Pays> findByClientsIsEmpty();

	Pays findByCode(String code);

}
