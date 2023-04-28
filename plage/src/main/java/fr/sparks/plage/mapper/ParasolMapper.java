package fr.sparks.plage.mapper;

import fr.sparks.plage.dto.ParasolDto;
import fr.sparks.plage.entity.Parasol;

public interface ParasolMapper {

    Parasol toEntity(ParasolDto parasolDto);

    ParasolDto toDto(Parasol parasol);
}
