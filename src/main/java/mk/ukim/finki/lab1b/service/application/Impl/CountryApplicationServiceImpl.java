package mk.ukim.finki.lab1b.service.application.Impl;

import mk.ukim.finki.lab1b.dto.CreateCountryDto;
import mk.ukim.finki.lab1b.dto.DisplayCountryDto;
import mk.ukim.finki.lab1b.model.Views.HostPerCountryView;
import mk.ukim.finki.lab1b.repository.HostPerCountryViewRepository;
import mk.ukim.finki.lab1b.service.application.CountryApplicationService;
import mk.ukim.finki.lab1b.service.domain.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryApplicationServiceImpl implements CountryApplicationService {

    private final CountryService countryService;
    private final HostPerCountryViewRepository hostPerCountryViewRepository;

    public CountryApplicationServiceImpl(CountryService countryService, HostPerCountryViewRepository hostPerCountryViewRepository) {
        this.countryService = countryService;
        this.hostPerCountryViewRepository = hostPerCountryViewRepository;
    }

    @Override
    public List<DisplayCountryDto> findAll() {
        return DisplayCountryDto.from(countryService.findAll());
    }

    @Override
    public Optional<DisplayCountryDto> findById(Long id) {
        return countryService.findById(id).map(DisplayCountryDto::from);
    }

    @Override
    public Optional<DisplayCountryDto> update(Long id, CreateCountryDto createCountryDto) {
        return countryService.update(id, createCountryDto.toCountry()).map(DisplayCountryDto::from);
    }

    @Override
    public Optional<DisplayCountryDto> save(CreateCountryDto createCountryDto) {
        return countryService.save(createCountryDto.toCountry()).map(DisplayCountryDto::from);
    }

    @Override
    public void deleteById(Long id) {
        countryService.deleteById(id);
    }




    @Override
    public List<HostPerCountryView> findAllHostsPerCountry() {
        return hostPerCountryViewRepository.findAll();
    }

    @Override
    public HostPerCountryView findHostPerCountry(Long id) {
        return hostPerCountryViewRepository.findById(id).orElseThrow();
    }

    @Override
    public void refreshMaterializedView() {
        hostPerCountryViewRepository.refreshMaterializedView();
    }
}
