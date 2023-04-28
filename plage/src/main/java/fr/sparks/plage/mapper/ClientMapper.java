package fr.sparks.plage.mapper;

import fr.sparks.plage.dto.ClientDto;
import fr.sparks.plage.entity.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = { PaysMapper.class })
public interface ClientMapper {

	@Mapping(source = "paysDto", target = "pays")
	@Mapping(source = "motDePasse", target = "mdp")
	Client toEntity(ClientDto clientDto);

	@Mapping(source = "pays", target = "paysDto")
	@Mapping(source = "mdp", target = "motDePasse")
	ClientDto toDto(Client client);

}