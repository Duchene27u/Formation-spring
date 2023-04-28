package fr.sparks.plage.dao;

import fr.sparks.plage.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface FileDao extends JpaRepository<File, Long> {

/*    @Override
    @RestResource(exported = false)
    File save(File file);

    @Override
    @RestResource(exported = false)
    <S extends File> List<S> saveAll(Iterable<S> entities);*/
}
