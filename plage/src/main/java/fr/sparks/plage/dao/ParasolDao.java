package fr.sparks.plage.dao;

import fr.sparks.plage.entity.File;
import fr.sparks.plage.entity.Parasol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ParasolDao extends JpaRepository<Parasol, Long> {

	// Méthode qui renvoie les parasols de la file donnée en paramètre
	List<Parasol> findByFile(File file);
	
	List<Parasol> findByFileNumero(byte numero);
	
	@Transactional
	// @Modifying : pas nécessaire car pas de #Query sur cette méthode
	int deleteByFileNumero(byte numero);
}
