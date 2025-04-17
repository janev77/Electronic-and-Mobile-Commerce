package mk.ukim.finki.lab1b.service.domain;

import mk.ukim.finki.lab1b.model.Domain.TemporaryReservation;

import java.util.List;
import java.util.Optional;

public interface TemporaryReservationService {
//    List<TemporaryReservation> findAll();
//
//    Optional<TemporaryReservation> findById(Long id);
//
//    Optional<TemporaryReservation> save(TemporaryReservation temporaryReservation);
//
//    Optional<TemporaryReservation> update(Long id, TemporaryReservation temporaryReservation);
//
//    void deleteById(Long id);



    public Optional<TemporaryReservation> addTemporaryReservation(TemporaryReservation temporaryReservation);

    public List<TemporaryReservation> getTemporaryReservationsForUser(String username);

    public void confirmAllReservationsForUser(String username);

}
