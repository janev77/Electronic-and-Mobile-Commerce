package mk.ukim.finki.lab1b.service.Impl;

import mk.ukim.finki.lab1b.model.Accommodation;
import mk.ukim.finki.lab1b.model.Dto.ReservationDto;
import mk.ukim.finki.lab1b.model.Host;
import mk.ukim.finki.lab1b.model.Reservation;
import mk.ukim.finki.lab1b.repository.AccommodationRepository;
import mk.ukim.finki.lab1b.repository.ReservationRepository;
import mk.ukim.finki.lab1b.service.AccommodationService;
import mk.ukim.finki.lab1b.service.ReservationService;
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
    public Optional<Reservation> save(ReservationDto reservationDto) {

        if (reservationDto.getCode() != null &&
                reservationDto.getStart_date() != null &&
                reservationDto.getEnd_date() != null &&
                reservationDto.getNumOfGuests() != null &&
                reservationDto.getPrice() != null &&
                accommodationService.findById(reservationDto.getAccommodation()).isPresent()) {

            Accommodation accommodation = accommodationService.findById(reservationDto.getAccommodation()).get();

            return Optional.of(reservationRepository.save(new Reservation(
                            reservationDto.getCode(),
                            reservationDto.getStart_date(),
                            reservationDto.getEnd_date(),
                            reservationDto.getNumOfGuests(),
                            reservationDto.getPrice(),
                            accommodation
                    )
            ));
        }
        System.out.println("Host not found or invalid data.");
        return Optional.empty();
    }


    @Override
    public Optional<Reservation> update(Long id, ReservationDto reservationDto) {
        return reservationRepository.findById(id).map(existingReservation -> {

            if (reservationDto.getCode() != null) {
                existingReservation.setCode(reservationDto.getCode());
            }

            if (reservationDto.getStart_date() != null) {
                existingReservation.setStart_date(reservationDto.getStart_date());
            }

            if (reservationDto.getEnd_date() != null) {
                existingReservation.setEnd_date(reservationDto.getEnd_date());
            }

            if (reservationDto.getNumOfGuests() != null) {
                existingReservation.setNumOfGuests(reservationDto.getNumOfGuests());
            }

            if (reservationDto.getAccommodation() != null && accommodationService.findById(reservationDto.getAccommodation()).isPresent()) {
                existingReservation.setAccommodation(accommodationService.findById(reservationDto.getAccommodation()).get());
            }

            if (reservationDto.getPrice() != null) {
                existingReservation.setPrice(reservationDto.getPrice());
            }

            return reservationRepository.save(existingReservation);
        });
    }

    @Override
    public void deleteById(Long id) {
        reservationRepository.deleteById(id);
    }
}
