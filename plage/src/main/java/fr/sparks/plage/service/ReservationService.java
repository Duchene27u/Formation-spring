package fr.sparks.plage.service;

import fr.sparks.plage.dto.ReservationDto;
import fr.sparks.plage.entity.Reservation;

import java.util.List;

public interface ReservationService {

    Reservation enregisterNouvelleResa(ReservationDto resaDto);

    List<Reservation> recupererReservations();

    Reservation updateReservation(ReservationDto resaDto);
}
