package mk.ukim.finki.lab1b.service.application;

import mk.ukim.finki.lab1b.dto.CreateReservationDto;
import mk.ukim.finki.lab1b.dto.DisplayReservationDto;

import java.util.List;
import java.util.Optional;

public interface ReservationApplicationService {

    List<DisplayReservationDto> findAll();

    Optional<DisplayReservationDto> findById(Long id);

    Optional<DisplayReservationDto> save(CreateReservationDto createReservationDto);

    Optional<DisplayReservationDto> update(Long id, CreateReservationDto createReservationDto);

    void deleteById(Long id);

//    Optional<DisplayReservationDto> addTemporaryReservation(CreateReservationDto createReservationDto, String username);
//
//    List<DisplayReservationDto> getTemporaryReservationsForUser(String username);
//
//    void confirmAllReservationsForUser(String username);
}