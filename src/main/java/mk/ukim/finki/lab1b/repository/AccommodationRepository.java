package mk.ukim.finki.lab1b.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import mk.ukim.finki.lab1b.model.Domain.Accommodation;
import org.springframework.stereotype.Repository;

@Repository
public interface AccommodationRepository extends JpaRepository<Accommodation, Long> {
}
