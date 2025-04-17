package mk.ukim.finki.lab1b.service.domain;

import mk.ukim.finki.lab1b.model.Domain.Accommodation;

import java.util.List;
import java.util.Optional;

public interface AccommodationService {

    List<Accommodation> findAll();

    Optional<Accommodation> findById(Long id);

    Optional<Accommodation> save(Accommodation accommodation);

    Optional<Accommodation> update(Long id, Accommodation accommodation);

    void deleteById(Long id);

}
