package fr.sparks.plage.service.impl;

import fr.sparks.plage.dao.ReservationDao;
import fr.sparks.plage.dto.ReservationDto;
import fr.sparks.plage.entity.Reservation;
import fr.sparks.plage.mapper.ReservationMapper;
import fr.sparks.plage.service.ReservationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationDao reservationDao;
    private final ReservationMapper reservationMapper;

    @Override
    public Reservation enregisterNouvelleResa(ReservationDto resaDto) {
        return reservationDao.save(reservationMapper.toEntity(resaDto));
    }

    @Override
    public List<Reservation> recupererReservations() {
        return reservationDao.findAll();
    }

    @Override
    public Reservation updateReservation(ReservationDto resaDto) {
        return null;
    }
}
