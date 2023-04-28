package fr.sparks.plage.mapper;

import fr.sparks.plage.dto.ReservationDto;
import fr.sparks.plage.entity.Reservation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ReservationMapper {

    ReservationDto toDto(Reservation resa);

    @Mapping(source ="idCLient", target="client.id")
    Reservation toEntity(ReservationDto resaDto);
}
