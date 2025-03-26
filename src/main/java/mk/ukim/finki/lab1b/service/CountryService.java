package mk.ukim.finki.lab1b.service;

import mk.ukim.finki.lab1b.model.Country;
import mk.ukim.finki.lab1b.model.Dto.CountryDto;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    List<Country> findAll();

    Optional<Country> findById(Long id);

    Optional<Country> update(Long id, CountryDto countryDto);

    Optional<Country> save(CountryDto countryDto);

    void deleteById(Long id);
}
