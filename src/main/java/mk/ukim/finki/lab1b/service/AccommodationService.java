package mk.ukim.finki.lab1b.service;

import mk.ukim.finki.lab1b.model.Accommodation;
import mk.ukim.finki.lab1b.model.Dto.AccommodationDto;

import java.util.List;
import java.util.Optional;

public interface AccommodationService {

    List<Accommodation> findAll();

    Optional<Accommodation> findById(Long id);

    Optional<Accommodation> update(Long id, AccommodationDto accommodationDto);

    Optional<Accommodation> save(AccommodationDto accommodationDto);

    void deleteById(Long id);

}
