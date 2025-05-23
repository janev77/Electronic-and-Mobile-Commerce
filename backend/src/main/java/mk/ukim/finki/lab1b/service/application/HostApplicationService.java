package mk.ukim.finki.lab1b.service.application;

import mk.ukim.finki.lab1b.dto.CreateHostDto;
import mk.ukim.finki.lab1b.dto.DisplayHostDto;
import mk.ukim.finki.lab1b.model.Domain.Host;
import mk.ukim.finki.lab1b.model.Projections.HostProjection;
import mk.ukim.finki.lab1b.model.Views.AccommodationPerHostView;

import java.util.List;
import java.util.Optional;

public interface HostApplicationService {

    List<DisplayHostDto> findAll();

    Optional<DisplayHostDto> save(CreateHostDto hostDto);

    Optional<DisplayHostDto> findById(Long id);

    Optional<DisplayHostDto> update(Long id, CreateHostDto hostDto);

    void deleteById(Long id);



    List<AccommodationPerHostView> findAllAccommodationsPerHost();
    AccommodationPerHostView findAccommodationsPerHost(Long id);
    void refreshMaterializedView();


    List<HostProjection> getAllHostNames();

}
