package fr.sparks.plage.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.sparks.plage.business.Utilisateur;

public interface UtilisateurDao extends JpaRepository<Utilisateur, Long> {

	// Requête par dérivation
	Utilisateur findByEmailAndMotDePasse(String email, String motDePasse);
	
	// Requête par dérivation
	boolean existsByEmail(String email);
}
