package fr.sparks.plage.dao;

import fr.sparks.plage.entity.Pays;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaysDao extends JpaRepository<Pays, String> {
	
	// Méthode qui renvoie les pays pour lesquels nous n'avons pas encore de clients
	List<Pays> findByClientsIsEmpty();

	Pays findByCode(String code);

}
