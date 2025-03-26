package mk.ukim.finki.lab1b.service.Impl;

import mk.ukim.finki.lab1b.model.Accommodation;
import mk.ukim.finki.lab1b.model.Dto.AccommodationDto;
import mk.ukim.finki.lab1b.model.Host;
import mk.ukim.finki.lab1b.repository.AccommodationRepository;
import mk.ukim.finki.lab1b.service.AccommodationService;
import mk.ukim.finki.lab1b.service.HostService;
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
    public Optional<Accommodation> update(Long id, AccommodationDto accommodationDto) {
        return accommodationRepository.findById(id).map(existingAccommodation -> {

            if (accommodationDto.getName() != null) {
                existingAccommodation.setName(accommodationDto.getName());
            }
            if (accommodationDto.getNumRooms() != null) {
                existingAccommodation.setNumRooms(accommodationDto.getNumRooms());
            }
            if (accommodationDto.getHost() != null && hostService.findById(accommodationDto.getHost()).isPresent()) {
                existingAccommodation.setHost(hostService.findById(accommodationDto.getHost()).get());
            }
            if (accommodationDto.getCategory() != null) {
               existingAccommodation.setCategory(accommodationDto.getCategory());
            }
            if (accommodationDto.getMarkRented() != null) {
                existingAccommodation.setMarkRented(accommodationDto.getMarkRented());
            }

            return accommodationRepository.save(existingAccommodation);
        });
    }

    @Override
    public Optional<Accommodation> save(AccommodationDto accommodationDto) {
        System.out.println("Checking if host exists with ID: " + accommodationDto.getHost());
        if (accommodationDto.getCategory() != null &&
                accommodationDto.getHost() != null &&
                hostService.findById(accommodationDto.getHost()).isPresent()) {

            Host host = hostService.findById(accommodationDto.getHost()).get();
            System.out.println("Host found: " + host.getName());

            return Optional.of(accommodationRepository.save(new Accommodation(
                    accommodationDto.getName(),
                    accommodationDto.getCategory(),
                    host,
                    accommodationDto.getNumRooms(),
                    accommodationDto.getMarkRented())
            ));
        }
        System.out.println("Host not found or invalid data.");
        return Optional.empty();
    }

    @Override
    public void deleteById(Long id) {
        accommodationRepository.deleteById(id);
    }

    @Override
    public Optional<Accommodation> isRented(Long id) {
        return accommodationRepository.findById(id).map(existingAccommodation -> {
            existingAccommodation.setMarkRented(true);

            if (existingAccommodation.getNumRooms()>0){
                existingAccommodation.setNumRooms(existingAccommodation.getNumRooms() - 1);
            }
            return accommodationRepository.save(existingAccommodation);
        });
    }
}
