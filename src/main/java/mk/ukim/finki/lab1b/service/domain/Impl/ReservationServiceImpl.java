package mk.ukim.finki.lab1b.service.domain.Impl;

import mk.ukim.finki.lab1b.model.Domain.Accommodation;
import mk.ukim.finki.lab1b.model.Domain.Reservation;
import mk.ukim.finki.lab1b.repository.ReservationRepository;
import mk.ukim.finki.lab1b.service.domain.AccommodationService;
import mk.ukim.finki.lab1b.service.domain.ReservationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;
    private final AccommodationService accommodationService;

    public ReservationServiceImpl(ReservationRepository reservationRepository, AccommodationService accommodationService) {
        this.reservationRepository = reservationRepository;
        this.accommodationService = accommodationService;
    }

    @Override
    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }
    @Override
    public Optional<Reservation> findById(Long id) {
        return reservationRepository.findById(id);
    }

    @Override
    public Optional<Reservation> save(Reservation reservation) {

        if (reservation.getCode() != null &&
                reservation.getStart_date() != null &&
                reservation.getEnd_date() != null &&
                reservation.getNumOfGuests() != null &&
                reservation.getPrice() != null &&
                accommodationService.findById(reservation.getAccommodation().getId()).isPresent()) {

            Accommodation accommodation = accommodationService.findById(reservation.getAccommodation().getId()).get();

            return Optional.of(reservationRepository.save(new Reservation(
                    reservation.getCode(),
                    reservation.getStart_date(),
                    reservation.getEnd_date(),
                    reservation.getNumOfGuests(),
                    reservation.getPrice(),
                            accommodation
                    )
            ));
        }
        System.out.println("Host not found or invalid data.");
        return Optional.empty();
    }


    @Override
    public Optional<Reservation> update(Long id, Reservation reservation) {
        return reservationRepository.findById(id).map(existingReservation -> {

            if (reservation.getCode() != null) {
                existingReservation.setCode(reservation.getCode());
            }

            if (reservation.getStart_date() != null) {
                existingReservation.setStart_date(reservation.getStart_date());
            }

            if (reservation.getEnd_date() != null) {
                existingReservation.setEnd_date(reservation.getEnd_date());
            }

            if (reservation.getNumOfGuests() != null) {
                existingReservation.setNumOfGuests(reservation.getNumOfGuests());
            }

            if (reservation.getAccommodation() != null && accommodationService.findById(reservation.getAccommodation().getId()).isPresent()) {
                existingReservation.setAccommodation(accommodationService.findById(reservation.getAccommodation().getId()).get());
            }

            if (reservation.getPrice() != null) {
                existingReservation.setPrice(reservation.getPrice());
            }

            return reservationRepository.save(existingReservation);
        });
    }

    @Override
    public void deleteById(Long id) {
        reservationRepository.deleteById(id);
    }

}
