package mk.ukim.finki.lab1b.service.application.Impl;

import mk.ukim.finki.lab1b.dto.CreateHostDto;
import mk.ukim.finki.lab1b.dto.DisplayHostDto;
import mk.ukim.finki.lab1b.events.HostChangedEvent;
import mk.ukim.finki.lab1b.events.HostCreatedEvent;
import mk.ukim.finki.lab1b.events.HostDeletedEvent;
import mk.ukim.finki.lab1b.model.Domain.Country;
import mk.ukim.finki.lab1b.model.Domain.Host;
import mk.ukim.finki.lab1b.model.Projections.HostProjection;
import mk.ukim.finki.lab1b.model.Views.AccommodationPerHostView;
import mk.ukim.finki.lab1b.repository.AccommodationPerHostViewRepository;
import mk.ukim.finki.lab1b.repository.HostRepository;
import mk.ukim.finki.lab1b.service.application.HostApplicationService;
import mk.ukim.finki.lab1b.service.domain.CountryService;
import mk.ukim.finki.lab1b.service.domain.HostService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HostApplicationServiceImpl implements HostApplicationService {

    private final HostService hostService;
    private final CountryService countryService;
    private final AccommodationPerHostViewRepository accommodationPerHostViewRepository;
    private final ApplicationEventPublisher applicationEventPublisher;
    private final HostRepository hostRepository;

    public HostApplicationServiceImpl(HostService hostService, CountryService countryService, AccommodationPerHostViewRepository accommodationPerHostViewRepository, ApplicationEventPublisher applicationEventPublisher, HostRepository hostRepository) {
        this.hostService = hostService;
        this.countryService = countryService;
        this.accommodationPerHostViewRepository = accommodationPerHostViewRepository;
        this.applicationEventPublisher = applicationEventPublisher;
        this.hostRepository = hostRepository;
    }

    @Override
    public List<DisplayHostDto> findAll() {
        return DisplayHostDto.from(hostService.findAll());
    }

    @Override
    public Optional<DisplayHostDto> findById(Long id) {
        return hostService.findById(id).map(DisplayHostDto::from);
    }

    @Override
    public Optional<DisplayHostDto> save(CreateHostDto createHostDto) {
        Optional<Country> country = countryService.findById(createHostDto.country());

        if (country.isPresent()) {
            Host host = createHostDto.toHost(country.get());

            Host savedHost = hostRepository.save(host);

            this.applicationEventPublisher.publishEvent(new HostCreatedEvent(host));

            return Optional.of(DisplayHostDto.from(savedHost));
        }
        return Optional.empty();
    }



    @Override
    public Optional<DisplayHostDto> update(Long id, CreateHostDto createHostDto) {
        Optional<Country> country = countryService.findById(createHostDto.country());

        Host host = createHostDto.toHost(country.orElse(null));
        this.applicationEventPublisher.publishEvent(new HostChangedEvent(host));

        return hostService.update(id, createHostDto.toHost(country.orElse(null))).map(DisplayHostDto::from);
    }

    @Override
    public void deleteById(Long id) {

        Host host = hostService.findById(id).orElse(null);
        hostService.deleteById(id);
        this.applicationEventPublisher.publishEvent(new HostDeletedEvent(host));
    }



    @Override
    public List<AccommodationPerHostView> findAllAccommodationsPerHost() {
        return accommodationPerHostViewRepository.findAll();
    }

    @Override
    public AccommodationPerHostView findAccommodationsPerHost(Long id) {
        return accommodationPerHostViewRepository.findById(id).orElseThrow();
    }

    @Override
    public void refreshMaterializedView() {
        accommodationPerHostViewRepository.refreshMaterializedView();
    }

    @Override
    public List<HostProjection> getAllHostNames() {
        return hostRepository.findAllBy();
    }
}
