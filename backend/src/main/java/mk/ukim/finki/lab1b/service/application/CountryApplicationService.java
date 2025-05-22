package mk.ukim.finki.lab1b.service.application;

import mk.ukim.finki.lab1b.dto.CreateCountryDto;
import mk.ukim.finki.lab1b.dto.DisplayCountryDto;
import mk.ukim.finki.lab1b.model.Domain.Country;
import mk.ukim.finki.lab1b.model.Views.AccommodationPerHostView;
import mk.ukim.finki.lab1b.model.Views.HostPerCountryView;

import java.util.List;
import java.util.Optional;

public interface CountryApplicationService {
    List<DisplayCountryDto> findAll();

    Optional<DisplayCountryDto> findById(Long id);

    Optional<DisplayCountryDto> update(Long id, CreateCountryDto createCountryDto);

    Optional<DisplayCountryDto> save(CreateCountryDto createCountryDto);

    void deleteById(Long id);


    List<HostPerCountryView> findAllHostsPerCountry();
    HostPerCountryView findHostPerCountry(Long id);
    void refreshMaterializedView();
}
