package mk.ukim.finki.lab1b.service.application.Impl;

import mk.ukim.finki.lab1b.dto.CreateAccommodationDto;
import mk.ukim.finki.lab1b.dto.DisplayAccommodationDto;
import mk.ukim.finki.lab1b.model.Domain.Accommodation;
import mk.ukim.finki.lab1b.model.Domain.Host;
import mk.ukim.finki.lab1b.service.application.AccommodationApplicationService;
import mk.ukim.finki.lab1b.service.domain.AccommodationService;
import mk.ukim.finki.lab1b.service.domain.HostService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class AccommodationApplicationServiceImpl implements AccommodationApplicationService {

    private final AccommodationService accommodationService;
    private final HostService hostService;

    public AccommodationApplicationServiceImpl(AccommodationService accommodationService, HostService hostService) {
        this.accommodationService = accommodationService;
        this.hostService = hostService;
    }

    @Override
    public List<DisplayAccommodationDto> findAll() {
        return DisplayAccommodationDto.from(accommodationService.findAll());
    }

    @Override
    public Optional<DisplayAccommodationDto> findById(Long id) {
        return accommodationService.findById(id).map(DisplayAccommodationDto::from);
    }

    @Override
    public Optional<DisplayAccommodationDto> save(CreateAccommodationDto createAccommodationDto) {

        Optional<Host> host = hostService.findById(createAccommodationDto.host());

        if (host.isPresent()) {
            return accommodationService.save(createAccommodationDto.toAccommodation(host.get())).map(DisplayAccommodationDto::from);

        }
        return Optional.empty();
    }

    @Override
    public Optional<DisplayAccommodationDto> update(Long id, CreateAccommodationDto createAccommodationDto) {
        Optional<Host> host = hostService.findById(createAccommodationDto.host());
        return accommodationService.update(id, createAccommodationDto.toAccommodation(host.orElse(null))).map(DisplayAccommodationDto::from);
    }

    @Override
    public void deleteById(Long id) {
        accommodationService.deleteById(id);
    }

    @Override
    public HashMap<String, Integer> statisticCategory() {

        List<Accommodation> accommodations = accommodationService.findAll();

        int rooms = 0;
        int houses = 0;
        int flats = 0;
        int apartments = 0;
        int hotels = 0;
        int motels = 0;

        for(Accommodation accommodation : accommodations){
            if (accommodation.getCategory().toString().equals("ROOM")){
                rooms++;
            }
            if (accommodation.getCategory().toString().equals("HOUSE")){
                houses++;
            }
            if (accommodation.getCategory().toString().equals("FLAT")){
                flats++;
            }
            if (accommodation.getCategory().toString().equals("APARTMENT")){
                apartments++;
            }
            if (accommodation.getCategory().toString().equals("HOTEL")){
                hotels++;
            }
            if (accommodation.getCategory().toString().equals("MOTEL")){
                motels++;
            }
        }

        HashMap<String, Integer> result = new HashMap<>();

        result.put("ROOM",rooms);
        result.put("HOUSE",houses);
        result.put("FLAT",flats);
        result.put("APARTMENT",apartments);
        result.put("HOTEL",hotels);
        result.put("MOTEL",motels);

        return result;
    }
}
