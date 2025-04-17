package mk.ukim.finki.lab1b.service.domain.Impl;

import mk.ukim.finki.lab1b.model.Domain.Accommodation;
import mk.ukim.finki.lab1b.model.Domain.Host;
import mk.ukim.finki.lab1b.repository.AccommodationRepository;
import mk.ukim.finki.lab1b.service.domain.AccommodationService;
import mk.ukim.finki.lab1b.service.domain.HostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccommodationServiceImpl implements AccommodationService {

    private final AccommodationRepository accommodationRepository;
    private final HostService hostService;

    public AccommodationServiceImpl(AccommodationRepository accommodationRepository, HostService hostService) {
        this.accommodationRepository = accommodationRepository;
        this.hostService = hostService;
    }

    @Override
    public List<Accommodation> findAll() {
        return accommodationRepository.findAll();
    }

    @Override
    public Optional<Accommodation> findById(Long id) {
        return accommodationRepository.findById(id);
    }

    @Override
    public Optional<Accommodation> update(Long id, Accommodation accommodation) {
        return accommodationRepository.findById(id).map(existingAccommodation -> {

            if (accommodation.getName() != null) {
                existingAccommodation.setName(accommodation.getName());
            }
            if (accommodation.getNumRooms() != null) {
                existingAccommodation.setNumRooms(accommodation.getNumRooms());
            }
            if (accommodation.getHost() != null && hostService.findById(accommodation.getHost().getId()).isPresent()) {
                existingAccommodation.setHost(hostService.findById(accommodation.getHost().getId()).get());
            }
            if (accommodation.getCategory() != null) {
               existingAccommodation.setCategory(accommodation.getCategory());
            }

            return accommodationRepository.save(existingAccommodation);
        });
    }

    @Override
    public Optional<Accommodation> save(Accommodation accommodation) {
        System.out.println("Checking if host exists with ID: " + accommodation.getHost());
        if (accommodation.getCategory() != null &&
                accommodation.getHost() != null &&
                hostService.findById(accommodation.getHost().getId()).isPresent()) {

            Host host = hostService.findById(accommodation.getHost().getId()).get();
            System.out.println("Host found: " + host.getName());

            return Optional.of(accommodationRepository.save(new Accommodation(
                    accommodation.getName(),
                    accommodation.getCategory(),
                    host,
                    accommodation.getNumRooms()
                    )
            ));
        }
        System.out.println("Host not found or invalid data.");
        return Optional.empty();
    }

    @Override
    public void deleteById(Long id) {
        accommodationRepository.deleteById(id);
    }

}
