package fr.sparks.plage.mapper;

import java.util.List;

import org.mapstruct.Context;
import org.mapstruct.Mapper;

import fr.sparks.plage.business.Reservation;
import fr.sparks.plage.dto.ReservationDto;

@Mapper(componentModel = "spring")
public interface ReservationMapper {

	ReservationDto toDto(Reservation location, @Context CycleAvoidingMappingContext context);	

	List<ReservationDto> toDtos(List<Reservation> reservations, @Context CycleAvoidingMappingContext context);

	Reservation toEntity(ReservationDto locationDto, @Context CycleAvoidingMappingContext context);

	List<Reservation> toEntities(List<ReservationDto> locationsDto, @Context CycleAvoidingMappingContext context);
}