package mk.ukim.finki.lab1b.repository;

import mk.ukim.finki.lab1b.model.Domain.TemporaryReservation;
import mk.ukim.finki.lab1b.model.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface TemporaryReservationRepository extends JpaRepository<TemporaryReservation, Long> {

}
