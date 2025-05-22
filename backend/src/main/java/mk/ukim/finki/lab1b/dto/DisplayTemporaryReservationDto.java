package mk.ukim.finki.lab1b.dto;

import mk.ukim.finki.lab1b.model.Domain.Accommodation;
import mk.ukim.finki.lab1b.model.Domain.TemporaryReservation;
import mk.ukim.finki.lab1b.model.Domain.User;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public record DisplayTemporaryReservationDto(
        Long id,
        String code,
        LocalDate start_date,
        LocalDate end_date,
        Integer numOfGuests,
        Integer price,
        Long accommodation,
        String user,
        boolean confirmed) {

    public static DisplayTemporaryReservationDto from(TemporaryReservation reservation) {
        return new DisplayTemporaryReservationDto(
                reservation.getId(),
                reservation.getCode(),
                reservation.getStart_date(),
                reservation.getEnd_date(),
                reservation.getNumOfGuests(),
                reservation.getPrice(),
                reservation.getAccommodation().getId(),
                reservation.getUser().getUsername(),
                reservation.isConfirmed()
        );
    }

    public static List<DisplayTemporaryReservationDto> from(List<TemporaryReservation> reservations) {
        return  reservations.stream().map(DisplayTemporaryReservationDto::from).collect(Collectors.toList());
    }

    public TemporaryReservation toReservation(Accommodation accommodation, User user) {
        return new TemporaryReservation(code,start_date,end_date,numOfGuests,price,accommodation,user);
    }
}
