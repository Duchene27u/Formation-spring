package fr.sparks.plage.dao;

import fr.sparks.plage.entity.Client;
import fr.sparks.plage.entity.LienDeParente;
import fr.sparks.plage.entity.Pays;
import fr.sparks.plage.util.NbInscrits;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ClientDao extends JpaRepository<Client, Long> {
//	@Value("${requete-clients-par-code-pays}")
//	final String requete;
//	
	// Requêtes par dérivation (query method)
	
	/**
	 * Méthode qui renvoie tous les clients résidant dans le pays donné en paramètre
	 * 
	 * @param pays
	 * @return
	 */
	List<Client> findByPays(Pays pays);
	
	List<Client> findByPaysNom(String nom);
	
	List<Client> findByPaysCode(String code);
	
	List<Client> findByPaysAndLienDeParente(Pays pays, LienDeParente lienDeParente);

	List<Client> findByPaysAndDateHeureInscriptionBetween(Pays pays, LocalDateTime dateDebut, LocalDateTime dateFin);

	// Utilisation de la navigabilité
	List<Client> findByPaysNomStartingWith(String debut);

	Optional<Client> findByEmail(String email);

	// Méthodes annotées @Query
	// Liste des clients dont le prénom est Alexis et résidant en France
	// Hibernate a généré la requête SQL suivante
	// Hibernate: select client0_.id as id2_7_, client0_.email as email3_7_, client0_.mot_de_passe as mot_de_p4_7_, client0_.nom as nom5_7_, client0_.prenom as prenom6_7_, client0_.date_heure_inscription as date_heu7_7_, client0_.lien_de_parente_id as lien_de_9_7_, client0_.pays_code as pays_co10_7_ from utilisateur client0_ cross join pays pays1_ where client0_.type_utilisateur='Client' and client0_.pays_code=pays1_.code and client0_.prenom='Alexis' and pays1_.nom='France'
	// Text blocks
	@Query("FROM Client	WHERE prenom='Alexis' AND pays.nom='France'")
	List<Client> findlientsHavingFirstNameAlexisAndLivingInFrance();

	// Lister les clients qui se sont inscrits depuis le 01/01/2023
	@Query("FROM Client	WHERE dateHeureInscription>='2023-01-01'")
	List<Client> findlientsWhoRegisteredIn2023();

	// Lister les clients espagnols
	@Query("FROM Client	WHERE pays.nom='Espagne'")
	List<Client> findSpanishlients();

	// Lister les clients dont le nom de famille débute par a
	@Query("FROM Client WHERE lower(nom) LIKE 'a%'")
	List<Client> findClientsHavingNameStartingWithA();

	@Query("FROM Client	WHERE pays=:lePays")
	List<Client> findByPaysHQL(@Param("lePays") Pays pays);

	@Query(value="FROM Client WHERE pays.code=:code")
	List<Client> findByPaysCodeHQL(String code);
	
	// Liste des clients qui se sont inscrits entre deux dates données en paramètre
	@Query( "FROM Client WHERE dateHeureInscription BETWEEN :dateDebut AND :dateFin	ORDER BY nom, prenom")
	List<Client> findClientsWhoRegisteredBetween(LocalDateTime dateDebut, LocalDateTime dateFin);

	// Liste des clients du pays donné en paramètre qui se sont inscrits entre deux dates données en paramètre
	@Query("FROM Client	WHERE dateHeureInscription BETWEEN :dateDebut AND :dateFin AND pays=:pays ORDER BY nom, prenom")
	List<Client> findClientsWhoRegisteredBetweenAndLivingInGivenCountry(LocalDateTime dateDebut, LocalDateTime dateFin, Pays pays);

	// Liste des clients du pays dont le nom est donné en paramètre et qui se sont inscrits entre deux dates données en paramètre
	@Query("FROM Client	WHERE dateHeureInscription BETWEEN :dateDebut AND :dateFin AND pays.nom=:nomPays ORDER BY nom, prenom")
	List<Client> findClientsWhoRegisteredBetweenAndLivingInGivenCountryName(LocalDateTime dateDebut, LocalDateTime dateFin, String nomPays);

	@Query("FROM Client	WHERE day_of_month(dateHeureInscription)=day_of_month(current_date()) AND month(dateHeureInscription)=month"
			+ "(current_date())	AND year(dateHeureInscription)=year(current_date())")
	List<Client> findClientsWhoRegisteredToday();
	
	@Query("SELECT count(*) FROM Client	WHERE day_of_month(dateHeureInscription)=day_of_month(current_date()) AND month"
			+ "(dateHeureInscription)=month(current_date())	AND year(dateHeureInscription)=year(current_date())")
	long findNumberOfClientsWhoRegisteredToday();

	// Projection
	// Pour chaque ligne de résultat, Spring Data va créer une instance de NbInscrits
	// La requête HQL invoque le constructeur avec tous les paramètres de la classe NbInscrits
	@Query(value = "SELECT new fr.sparks.plage.util.NbInscrits(year(c.dateHeureInscription), month(c.dateHeureInscription), COUNT(c.id)) "
			+ "FROM Client c GROUP BY year(c.dateHeureInscription), month(c.dateHeureInscription) ORDER BY year(c.dateHeureInscription), "
			+ "month(c.dateHeureInscription)")
	List<NbInscrits> findNbInscrits();

	@Transactional
	long deleteByPays(Pays pays);

	@Transactional
	long deleteByPaysCode(String codePays);
	
	@Transactional
	@Modifying
	@Query("UPDATE Client SET nom=upper(nom)")
	void updateClientName();
}
