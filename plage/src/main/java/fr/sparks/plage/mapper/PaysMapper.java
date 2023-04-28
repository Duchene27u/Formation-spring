package fr.sparks.plage.mapper;

import fr.sparks.plage.dto.PaysDto;
import fr.sparks.plage.entity.Pays;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PaysMapper {

	PaysMapper INSTANCE = Mappers.getMapper(PaysMapper.class);

	PaysDto toDto(Pays pays);

	Pays toEntity(PaysDto paysDto);

}
