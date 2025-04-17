package mk.ukim.finki.lab1b.service.application;

import mk.ukim.finki.lab1b.dto.CreateAccommodationDto;
import mk.ukim.finki.lab1b.dto.DisplayAccommodationDto;
import mk.ukim.finki.lab1b.model.Domain.Accommodation;
import mk.ukim.finki.lab1b.model.Enumerations.Category;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface AccommodationApplicationService {

    List<DisplayAccommodationDto> findAll();

    Optional<DisplayAccommodationDto> findById(Long id);

    Optional<DisplayAccommodationDto> update(Long id, CreateAccommodationDto accommodationDto);

    Optional<DisplayAccommodationDto> save(CreateAccommodationDto accommodationDto);

    void deleteById(Long id);

    Map<Category, Long> statisticCategory();


}
