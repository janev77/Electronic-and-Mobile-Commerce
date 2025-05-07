package mk.ukim.finki.lab1b.service.domain.Impl;

import mk.ukim.finki.lab1b.model.Domain.Accommodation;
import mk.ukim.finki.lab1b.model.Domain.TemporaryReservation;
import mk.ukim.finki.lab1b.repository.TemporaryReservationRepository;
import mk.ukim.finki.lab1b.service.domain.AccommodationService;
import mk.ukim.finki.lab1b.service.domain.TemporaryReservationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TemporaryReservationServiceImpl implements TemporaryReservationService {

    private final TemporaryReservationRepository temporaryReservationRepository;
    private final AccommodationService accommodationService;

    public TemporaryReservationServiceImpl(TemporaryReservationRepository temporaryReservationRepository, AccommodationService accommodationService) {
        this.temporaryReservationRepository = temporaryReservationRepository;
        this.accommodationService = accommodationService;
    }

//    @Override
//    public List<TemporaryReservation> findAll() {
//        return temporaryReservationRepository.findAll();
//    }
//    @Override
//    public Optional<TemporaryReservation> findById(Long id) {
//        return temporaryReservationRepository.findById(id);
//    }
//
//    @Override
//    public Optional<TemporaryReservation> save(TemporaryReservation temporaryReservation) {
//
//        if (temporaryReservation.getCode() != null &&
//                temporaryReservation.getStart_date() != null &&
//                temporaryReservation.getEnd_date() != null &&
//                temporaryReservation.getNumOfGuests() != null &&
//                temporaryReservation.getPrice() != null &&
//                accommodationService.findById(temporaryReservation.getAccommodation().getId()).isPresent()) {
//
//            Accommodation accommodation = accommodationService.findById(temporaryReservation.getAccommodation().getId()).get();
//
//            return Optional.of(temporaryReservationRepository.save(new TemporaryReservation(
//                    temporaryReservation.getCode(),
//                    temporaryReservation.getStart_date(),
//                    temporaryReservation.getEnd_date(),
//                    temporaryReservation.getNumOfGuests(),
//                    temporaryReservation.getPrice(),
//                            accommodation
//                    )
//            ));
//        }
//        System.out.println("Host not found or invalid data.");
//        return Optional.empty();
//    }
//
//
//    @Override
//    public Optional<TemporaryReservation> update(Long id, TemporaryReservation temporaryReservation) {
//        return temporaryReservationRepository.findById(id).map(existingReservation -> {
//
//            if (temporaryReservation.getCode() != null) {
//                existingReservation.setCode(temporaryReservation.getCode());
//            }
//
//            if (temporaryReservation.getStart_date() != null) {
//                existingReservation.setStart_date(temporaryReservation.getStart_date());
//            }
//
//            if (temporaryReservation.getEnd_date() != null) {
//                existingReservation.setEnd_date(temporaryReservation.getEnd_date());
//            }
//
//            if (temporaryReservation.getNumOfGuests() != null) {
//                existingReservation.setNumOfGuests(temporaryReservation.getNumOfGuests());
//            }
//
//            if (temporaryReservation.getAccommodation() != null && accommodationService.findById(temporaryReservation.getAccommodation().getId()).isPresent()) {
//                existingReservation.setAccommodation(accommodationService.findById(temporaryReservation.getAccommodation().getId()).get());
//            }
//
//            if (temporaryReservation.getPrice() != null) {
//                existingReservation.setPrice(temporaryReservation.getPrice());
//            }
//
//            return temporaryReservationRepository.save(existingReservation);
//        });
//    }
//
//    @Override
//    public void deleteById(Long id) {
//        temporaryReservationRepository.deleteById(id);
//    }

    @Override
    public Optional<TemporaryReservation> addTemporaryReservation(TemporaryReservation reservation) {

        Accommodation accommodation = accommodationService.findById(reservation.getAccommodation().getId()).get();

        if (accommodation.getNumRooms() > 0 ){
            accommodation.setNumRooms(accommodation.getNumRooms() - 1);
            return Optional.of(temporaryReservationRepository.save(reservation));
        }
        return Optional.empty();
    }

    @Override
    public List<TemporaryReservation> getTemporaryReservationsForUser(String username) {
        return temporaryReservationRepository.findAll().stream().filter(reservation -> reservation.getUser().getUsername().equals(username)&&!reservation.isConfirmed()).collect(Collectors.toList());

    }

    @Override
    public void confirmAllReservationsForUser(String username) {
        List<TemporaryReservation> reservations = getTemporaryReservationsForUser(username);
        reservations.forEach(reservation -> {
            reservation.setConfirmed(true);
            Accommodation accommodation =accommodationService.findById(reservation.getAccommodation().getId()).get();
            accommodation.setReserved(true);

            accommodationService.save(accommodation);
            temporaryReservationRepository.save(reservation);
        });
    }
}
