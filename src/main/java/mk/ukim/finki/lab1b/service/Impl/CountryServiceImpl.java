package mk.ukim.finki.lab1b.service.Impl;

import mk.ukim.finki.lab1b.model.Accommodation;
import mk.ukim.finki.lab1b.model.Country;
import mk.ukim.finki.lab1b.model.Dto.CountryDto;
import mk.ukim.finki.lab1b.model.Host;
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
    public Optional<Country> update(Long id, CountryDto countryDto) {
        return countryRepository.findById(id).map(existingCountry -> {

            if (countryDto.getName() != null) {
                existingCountry.setName(countryDto.getName());
            }
            if (countryDto.getContinent() != null) {
                existingCountry.setContinent(countryDto.getContinent());
            }
            return countryRepository.save(existingCountry);
        });
    }

    @Override
    public Optional<Country> save(CountryDto countryDto) {

        if (countryDto.getName() != null &&
                countryDto.getContinent() != null) {

            return Optional.of(countryRepository.save(new Country(
                    countryDto.getName(),
                    countryDto.getContinent()
            )));
        }
        System.out.println("Host not found or invalid data.");
        return Optional.empty();
    }

    @Override
    public void deleteById(Long id) {
        countryRepository.deleteById(id);
    }
}
