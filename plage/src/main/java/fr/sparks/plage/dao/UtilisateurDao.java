package fr.sparks.plage.dao;

import fr.sparks.plage.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurDao extends JpaRepository<Utilisateur, Long> {

	// Requête par dérivation
	Utilisateur findByEmailAndMdp(String email, String motDePasse);
	
	// Requête par dérivation
	boolean existsByEmail(String email);
}
