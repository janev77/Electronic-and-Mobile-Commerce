package mk.ukim.finki.lab1b.dto;

import mk.ukim.finki.lab1b.model.Domain.Accommodation;
import mk.ukim.finki.lab1b.model.Domain.Reservation;
import mk.ukim.finki.lab1b.model.Domain.User;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public record CreateReservationDto(
        String code,
        LocalDate start_date,
        LocalDate end_date,
        Integer numOfGuests,
        Integer price,
        Long accommodationId) {

    public static CreateReservationDto from(Reservation reservation) {
        return new CreateReservationDto(
                reservation.getCode(),
                reservation.getStart_date(),
                reservation.getEnd_date(),
                reservation.getNumOfGuests(),
                reservation.getPrice(),
                reservation.getAccommodation().getId()

        );
    }

    public static List<CreateReservationDto> from(List<Reservation> reservations) {
        return  reservations.stream().map(CreateReservationDto::from).collect(Collectors.toList());
    }

    public Reservation toReservation(Accommodation accommodation) {
        return new Reservation(code,start_date,end_date,numOfGuests,price,accommodation);
    }

}
