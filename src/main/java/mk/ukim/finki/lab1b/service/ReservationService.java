package mk.ukim.finki.lab1b.service;

import mk.ukim.finki.lab1b.model.Dto.HostDto;
import mk.ukim.finki.lab1b.model.Dto.ReservationDto;
import mk.ukim.finki.lab1b.model.Host;
import mk.ukim.finki.lab1b.model.Reservation;

import java.util.List;
import java.util.Optional;

public interface ReservationService {
    List<Reservation> findAll();

    Optional<Reservation> save(ReservationDto reservationDto);

    Optional<Reservation> findById(Long id);

    Optional<Reservation> update(Long id, ReservationDto reservationDto);

    void deleteById(Long id);
}
