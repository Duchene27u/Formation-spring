package fr.sparks.plage.dao;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import fr.sparks.plage.business.Reservation;

public interface ReservationDao extends JpaRepository<Reservation, Long> {

	@Query(value="""
			FROM Reservation
			WHERE concessionnaire.prenom='Giuseppe'
			""", nativeQuery=false)
	List<Reservation> findByConcessionnaireGiuseppe();
	
	// Méthode qui renvoie les réservations qui débutent après la date donnée en paramètre
	List<Reservation> findByDateDebutAfter(LocalDate date);
	
	List<Reservation> findByDateDebutBetween(LocalDate debut, LocalDate fin);
	
	List<Reservation> findByMontantAReglerEnEurosGreaterThanAndDateDebutBetween(double montant,LocalDate debut, LocalDate fin);
	
	List<Reservation> findByClientNom(String nomDuClient);
	
	List<Reservation> findByConcessionnaireIsNull();
	
	@Transactional
	@Modifying
	void deleteByDateDebutAfter(LocalDate date);
	
}
