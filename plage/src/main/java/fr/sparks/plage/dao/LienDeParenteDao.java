package fr.sparks.plage.dao;

import fr.sparks.plage.entity.LienDeParente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LienDeParenteDao extends JpaRepository<LienDeParente, Long> {

	LienDeParente findByNom(String nom);

}
