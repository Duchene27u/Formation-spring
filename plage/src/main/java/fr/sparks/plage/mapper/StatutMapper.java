package fr.sparks.plage.mapper;

import fr.sparks.plage.dto.StatutDto;
import fr.sparks.plage.entity.Statut;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface StatutMapper {

    Statut toEntity(StatutDto statutDto);

    StatutDto toDto(Statut statut);

}
