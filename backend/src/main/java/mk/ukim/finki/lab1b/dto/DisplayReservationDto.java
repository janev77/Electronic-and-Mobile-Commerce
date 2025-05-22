package mk.ukim.finki.lab1b.dto;

import mk.ukim.finki.lab1b.model.Domain.Accommodation;
import mk.ukim.finki.lab1b.model.Domain.Reservation;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public record DisplayReservationDto(
        Long id,
        String code,
        LocalDate start_date,
        LocalDate end_date,
        Integer numOfGuests,
        Integer price,
        Long accommodation) {

    public static DisplayReservationDto from(Reservation reservation) {
        return new DisplayReservationDto(
                reservation.getId(),
                reservation.getCode(),
                reservation.getStart_date(),
                reservation.getEnd_date(),
                reservation.getNumOfGuests(),
                reservation.getPrice(),
                reservation.getAccommodation().getId()
        );
    }

    public static List<DisplayReservationDto> from(List<Reservation> reservations) {
        return  reservations.stream().map(DisplayReservationDto::from).collect(Collectors.toList());
    }

    public Reservation toReservation(Accommodation accommodation) {
        return new Reservation(code,start_date,end_date,numOfGuests,price,accommodation);
    }
}
