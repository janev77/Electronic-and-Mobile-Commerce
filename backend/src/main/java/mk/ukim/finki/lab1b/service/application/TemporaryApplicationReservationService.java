package mk.ukim.finki.lab1b.service.application;

import mk.ukim.finki.lab1b.dto.CreateReservationDto;
import mk.ukim.finki.lab1b.dto.CreateTemporaryReservationDto;
import mk.ukim.finki.lab1b.dto.DisplayReservationDto;
import mk.ukim.finki.lab1b.dto.DisplayTemporaryReservationDto;

import java.util.List;
import java.util.Optional;

public interface TemporaryApplicationReservationService {

//    List<DisplayTemporaryReservationDto> findAll();
//
//    Optional<DisplayTemporaryReservationDto> findById(Long id);
//
//    Optional<DisplayTemporaryReservationDto> save(CreateTemporaryReservationDto createReservationDto);
//
//    Optional<DisplayTemporaryReservationDto> update(Long id, CreateTemporaryReservationDto createReservationDto);
//
//    void deleteById(Long id);

    Optional<DisplayTemporaryReservationDto> addTemporaryReservation(CreateTemporaryReservationDto createReservationDto, String username);

    List<DisplayTemporaryReservationDto> getTemporaryReservationsForUser(String username);

    void confirmAllReservationsForUser(String username);
}