package mk.ukim.finki.lab1b.service.Impl;

import mk.ukim.finki.lab1b.model.Country;
import mk.ukim.finki.lab1b.repository.CountryRepository;
import mk.ukim.finki.lab1b.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public Optional<Country> findById(Long id) {
        return countryRepository.findById(id);
    }

    @Override
    public Optional<Country> update(Long id, Country country) {
        return Optional.empty();
    }

    @Override
    public Optional<Country> save(Country country) {
        return Optional.empty();
    }

    @Override
    public void deleteById(Long id) {
        countryRepository.deleteById(id);
    }
}
