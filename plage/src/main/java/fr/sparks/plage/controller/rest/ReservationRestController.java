package fr.sparks.plage.controller.rest;

import fr.sparks.plage.dto.ReservationDto;
import fr.sparks.plage.entity.Reservation;
import fr.sparks.plage.service.impl.ReservationServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/reservations/")
public class ReservationRestController {

    private final ReservationServiceImpl reservationService;

    @Operation(description = "Enregistre une nouvelle réservation")
    @PostMapping
    public Reservation postReservation(@RequestBody ReservationDto resaDto) {
        return reservationService.enregisterNouvelleResa(resaDto);
    }

    @Operation(description = "Récupère toutes les réservations")
    @GetMapping
    public List<Reservation> getAllReservations(){
        return reservationService.recupererReservations();
    }


}
