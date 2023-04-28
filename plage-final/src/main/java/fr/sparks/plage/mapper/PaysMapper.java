package fr.sparks.plage.mapper;

import org.mapstruct.Mapper;

import fr.sparks.plage.business.Pays;
import fr.sparks.plage.dto.PaysDto;

@Mapper(componentModel = "spring")
public interface PaysMapper {
	
	PaysDto toDto(Pays pays);

	Pays toEntity(PaysDto paysDto);

}
