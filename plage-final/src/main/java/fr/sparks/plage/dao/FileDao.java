package fr.sparks.plage.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import fr.sparks.plage.business.File;

@RepositoryRestResource
public interface FileDao extends JpaRepository<File, Long> {

}
