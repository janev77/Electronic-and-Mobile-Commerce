package mk.ukim.finki.lab1b.service.domain;

import mk.ukim.finki.lab1b.model.Domain.Reservation;

import java.util.List;
import java.util.Optional;

public interface ReservationService {
    List<Reservation> findAll();

    Optional<Reservation> findById(Long id);

    Optional<Reservation> save(Reservation reservation);

    Optional<Reservation> update(Long id, Reservation reservation);

    void deleteById(Long id);



    public Optional<Reservation> addTemporaryReservation(Reservation reservation );

    public List<Reservation> getTemporaryReservationsForUser(String username);

    public void confirmAllReservationsForUser(String username);

}
