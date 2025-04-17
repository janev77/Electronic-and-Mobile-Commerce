package mk.ukim.finki.lab1b.service.application.Impl;

import mk.ukim.finki.lab1b.dto.CreateReservationDto;
import mk.ukim.finki.lab1b.dto.CreateTemporaryReservationDto;
import mk.ukim.finki.lab1b.dto.DisplayReservationDto;
import mk.ukim.finki.lab1b.dto.DisplayTemporaryReservationDto;
import mk.ukim.finki.lab1b.model.Domain.Accommodation;
import mk.ukim.finki.lab1b.model.Domain.User;
import mk.ukim.finki.lab1b.service.application.ReservationApplicationService;
import mk.ukim.finki.lab1b.service.application.TemporaryApplicationReservationService;
import mk.ukim.finki.lab1b.service.domain.AccommodationService;
import mk.ukim.finki.lab1b.service.domain.ReservationService;
import mk.ukim.finki.lab1b.service.domain.TemporaryReservationService;
import mk.ukim.finki.lab1b.service.domain.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TemporaryApplicationReservationServiceImpl implements TemporaryApplicationReservationService {

    private final TemporaryReservationService temporaryReservationService;
    private final AccommodationService accommodationService;
    private final UserService userService;

    public TemporaryApplicationReservationServiceImpl(TemporaryReservationService temporaryReservationService, AccommodationService accommodationService, UserService userService) {
        this.temporaryReservationService = temporaryReservationService;
        this.accommodationService = accommodationService;
        this.userService = userService;
    }


//    @Override
//    public List<DisplayTemporaryReservationDto> findAll() {
//        return DisplayTemporaryReservationDto.from(temporaryReservationService.findAll());
//    }
//
//    @Override
//    public Optional<DisplayTemporaryReservationDto> findById(Long id) {
//        return temporaryReservationService.findById(id).map(DisplayTemporaryReservationDto::from);
//    }
//
//    @Override
//    public Optional<DisplayTemporaryReservationDto> save(CreateTemporaryReservationDto createReservationDto) {
//
//        Optional<Accommodation> accommodation = accommodationService.findById(createReservationDto.accommodationId());
//
//
//        if (accommodation.isPresent()) {
//            return temporaryReservationService.save(createReservationDto.toReservation(accommodation.get())).map(DisplayTemporaryReservationDto::from);
//
//        }
//        return Optional.empty();
//
//    }
//
//    @Override
//    public Optional<DisplayTemporaryReservationDto> update(Long id, CreateTemporaryReservationDto createReservationDto) {
//
//        Optional<Accommodation> accommodation = accommodationService.findById(createReservationDto.accommodationId());
//
//        return temporaryReservationService.update(id, createReservationDto.toReservation(accommodation.orElse(null))).map(DisplayTemporaryReservationDto::from);
//
//    }
//
//    @Override
//    public void deleteById(Long id) {
//        temporaryReservationService.deleteById(id);
//    }

    @Override
    public Optional<DisplayTemporaryReservationDto> addTemporaryReservation(CreateTemporaryReservationDto createReservationDto, String username) {
        return temporaryReservationService.addTemporaryReservation(
                createReservationDto.toReservation(
                        accommodationService.findById(createReservationDto.accommodationId()).get(),
                        userService.findByUsername(username)

                )
        ).map(DisplayTemporaryReservationDto::from);
    }

    @Override
    public List<DisplayTemporaryReservationDto> getTemporaryReservationsForUser(String username) {
        return DisplayTemporaryReservationDto.from(temporaryReservationService.getTemporaryReservationsForUser(username));
    }

    @Override
    public void confirmAllReservationsForUser(String username) {
        temporaryReservationService.confirmAllReservationsForUser(username);
    }
}
