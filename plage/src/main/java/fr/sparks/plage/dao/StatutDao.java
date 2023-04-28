package fr.sparks.plage.dao;

import fr.sparks.plage.entity.Statut;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatutDao extends JpaRepository<Statut, Long> {

}
