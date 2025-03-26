package mk.ukim.finki.lab1b.service.Impl;

import mk.ukim.finki.lab1b.model.Accommodation;
import mk.ukim.finki.lab1b.model.Country;
import mk.ukim.finki.lab1b.model.Dto.HostDto;
import mk.ukim.finki.lab1b.model.Host;
import mk.ukim.finki.lab1b.repository.HostRepository;
import mk.ukim.finki.lab1b.service.CountryService;
import mk.ukim.finki.lab1b.service.HostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HostServiceImpl implements HostService {

    private final HostRepository hostRepository;
    private final CountryService countryService;

    public HostServiceImpl(HostRepository hostRepository, CountryService countryService) {
        this.hostRepository = hostRepository;
        this.countryService = countryService;
    }

    @Override
    public List<Host> findAll() {
        return hostRepository.findAll();
    }

    @Override
    public Optional<Host> findById(Long id) {
        return hostRepository.findById(id);
    }

    @Override
    public Optional<Host> save(HostDto hostDto) {

        if (hostDto.getName() != null &&
                hostDto.getSurname() != null &&
                countryService.findById(hostDto.getCountry()).isPresent()) {

            Country country = countryService.findById(hostDto.getCountry()).get();

            return Optional.of(hostRepository.save(new Host(
                    hostDto.getName(),
                    hostDto.getSurname(),
                    country)
            ));
        }

        return Optional.empty();
    }

    @Override
    public Optional<Host> update(Long id, HostDto hostDto) {
        return hostRepository.findById(id).map(existingHost -> {

            if (hostDto.getName() != null) {
                existingHost.setName(hostDto.getName());
            }
            if (hostDto.getSurname() != null) {
                existingHost.setSurname(hostDto.getSurname());
            }
            if (hostDto.getCountry() != null && countryService.findById(hostDto.getCountry()).isPresent()) {
                existingHost.setCountry(countryService.findById(hostDto.getCountry()).get());
            }
            return hostRepository.save(existingHost);
        });
    }

    @Override
    public void deleteById(Long id) {
        hostRepository.deleteById(id);
    }
}
