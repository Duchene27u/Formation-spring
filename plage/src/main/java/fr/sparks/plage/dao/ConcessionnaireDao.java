package fr.sparks.plage.dao;

import fr.sparks.plage.entity.Concessionnaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConcessionnaireDao extends JpaRepository<Concessionnaire, Long> {

}
