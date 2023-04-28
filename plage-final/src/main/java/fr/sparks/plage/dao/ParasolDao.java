package fr.sparks.plage.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import fr.sparks.plage.business.File;
import fr.sparks.plage.business.Parasol;

public interface ParasolDao extends JpaRepository<Parasol, Long> {

	// Méthode qui renvoie les parasols de la file donnée en paramètre
	List<Parasol> findByFile(File file);
	
	List<Parasol> findByFileNumero(byte numero);
	
	@Transactional
	// @Modifying : pas nécessaire car pas de #Query sur cette méthode
	int deleteByFileNumero(byte numero);

	Page<Parasol> findByFileId(Pageable pageable, Long idFile);
}
