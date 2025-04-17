package mk.ukim.finki.lab1b.service.application.Impl;

import mk.ukim.finki.lab1b.dto.CreateReservationDto;
import mk.ukim.finki.lab1b.dto.DisplayReservationDto;
import mk.ukim.finki.lab1b.model.Domain.Accommodation;
import mk.ukim.finki.lab1b.model.Domain.User;
import mk.ukim.finki.lab1b.service.application.ReservationApplicationService;
import mk.ukim.finki.lab1b.service.domain.AccommodationService;
import mk.ukim.finki.lab1b.service.domain.ReservationService;
import mk.ukim.finki.lab1b.service.domain.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationApplicationServiceImpl implements ReservationApplicationService {

    private final ReservationService reservationService;
    private final AccommodationService accommodationService;
    private final UserService userService;

    public ReservationApplicationServiceImpl(ReservationService reservationService, AccommodationService accommodationService, UserService userService) {
        this.reservationService = reservationService;
        this.accommodationService = accommodationService;
        this.userService = userService;
    }

    @Override
    public List<DisplayReservationDto> findAll() {
        return DisplayReservationDto.from(reservationService.findAll());
    }

    @Override
    public Optional<DisplayReservationDto> findById(Long id) {
        return reservationService.findById(id).map(DisplayReservationDto::from);
    }

    @Override
    public Optional<DisplayReservationDto> save(CreateReservationDto createReservationDto) {

        Optional<Accommodation> accommodation = accommodationService.findById(createReservationDto.accommodationId());

        if (accommodation.isPresent()) {
            return reservationService.save(createReservationDto.toReservation(accommodation.get())).map(DisplayReservationDto::from);

        }
        return Optional.empty();

    }

    @Override
    public Optional<DisplayReservationDto> update(Long id, CreateReservationDto createReservationDto) {

        Optional<Accommodation> accommodation = accommodationService.findById(createReservationDto.accommodationId());

        return reservationService.update(id, createReservationDto.toReservation(accommodation.orElse(null))).map(DisplayReservationDto::from);

    }

    @Override
    public void deleteById(Long id) {
        reservationService.deleteById(id);
    }

//    @Override
//    public Optional<DisplayReservationDto> addTemporaryReservation(CreateReservationDto createReservationDto, String username) {
//        return reservationService.addTemporaryReservation(
//                createReservationDto.toReservation(
//                        reservationService.findById(createReservationDto.accommodationId()).get().getAccommodation()
//                )
//        ).map(DisplayReservationDto::from);
//    }
//
//    @Override
//    public List<DisplayReservationDto> getTemporaryReservationsForUser(String username) {
//        return DisplayReservationDto.from(reservationService.getTemporaryReservationsForUser(username));
//    }
//
//    @Override
//    public void confirmAllReservationsForUser(String username) {
//        reservationService.confirmAllReservationsForUser(username);
//    }
}
