package mk.ukim.finki.lab1b.service.domain.Impl;

import mk.ukim.finki.lab1b.model.Domain.Country;
import mk.ukim.finki.lab1b.model.Domain.Host;
import mk.ukim.finki.lab1b.repository.HostRepository;
import mk.ukim.finki.lab1b.service.domain.CountryService;
import mk.ukim.finki.lab1b.service.domain.HostService;
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
    public Optional<Host> save(Host host) {

        if (host.getName() != null &&
                host.getSurname() != null &&
                countryService.findById(host.getCountry().getId()).isPresent()) {

            Country country = countryService.findById(host.getCountry().getId()).get();

            return Optional.of(hostRepository.save(new Host(
                    host.getName(),
                    host.getSurname(),
                    country)
            ));
        }

        return Optional.empty();
    }

    @Override
    public Optional<Host> update(Long id, Host host) {
        return hostRepository.findById(id).map(existingHost -> {

            if (host.getName() != null) {
                existingHost.setName(host.getName());
            }
            if (host.getSurname() != null) {
                existingHost.setSurname(host.getSurname());
            }
            if (host.getCountry() != null && countryService.findById(host.getCountry().getId()).isPresent()) {
                existingHost.setCountry(countryService.findById(host.getCountry().getId()).get());
            }
            return hostRepository.save(existingHost);
        });
    }

    @Override
    public void deleteById(Long id) {
        hostRepository.deleteById(id);
    }
}
