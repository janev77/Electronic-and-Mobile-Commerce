package mk.ukim.finki.lab1b.dto;

import mk.ukim.finki.lab1b.model.Domain.Accommodation;
import mk.ukim.finki.lab1b.model.Domain.TemporaryReservation;
import mk.ukim.finki.lab1b.model.Domain.User;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public record CreateTemporaryReservationDto(
        String code,
        LocalDate start_date,
        LocalDate end_date,
        Integer numOfGuests,
        Integer price,
        Long accommodationId,
        String user) {

    public static CreateTemporaryReservationDto from(TemporaryReservation reservation) {
        return new CreateTemporaryReservationDto(
                reservation.getCode(),
                reservation.getStart_date(),
                reservation.getEnd_date(),
                reservation.getNumOfGuests(),
                reservation.getPrice(),
                reservation.getAccommodation().getId(),
                reservation.getUser().getUsername()

        );
    }

    public static List<CreateTemporaryReservationDto> from(List<TemporaryReservation> reservations) {
        return  reservations.stream().map(CreateTemporaryReservationDto::from).collect(Collectors.toList());
    }

    public TemporaryReservation toReservation(Accommodation accommodation, User user) {
        return new TemporaryReservation(code,start_date,end_date,numOfGuests,price,accommodation,user);
    }

}
