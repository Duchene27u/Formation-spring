package fr.sparks.plage.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import fr.sparks.plage.business.Client;
import fr.sparks.plage.dto.ClientDto;

@Mapper(componentModel = "spring", uses = { PaysMapper.class })
public interface ClientMapper {

	@Mapping(source = "paysDto", target = "pays")
	Client toEntity(ClientDto clientDto);

	@Mapping(source = "pays", target = "paysDto")
	ClientDto toDto(Client client);

}