package mk.ukim.finki.lab1b.service.application.Impl;

import mk.ukim.finki.lab1b.dto.CreateAccommodationDto;
import mk.ukim.finki.lab1b.dto.DisplayAccommodationDto;
import mk.ukim.finki.lab1b.dto.DisplayAccommodationFlowDto;
import mk.ukim.finki.lab1b.model.Domain.Accommodation;
import mk.ukim.finki.lab1b.model.Domain.Host;
import mk.ukim.finki.lab1b.model.Enumerations.Category;
import mk.ukim.finki.lab1b.service.application.AccommodationApplicationService;
import mk.ukim.finki.lab1b.service.domain.AccommodationService;
import mk.ukim.finki.lab1b.service.domain.HostService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

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
    public Map<Category, Long> statisticCategory() {

//        List<Accommodation> accommodations = accommodationService.findAll();
//
//        HashMap<String,Integer> result = new HashMap<>();
//
//        for (Accommodation accommodation : accommodations){
//            String category = accommodation.getCategory().toString();
//            result.put(category,result.getOrDefault(category,0)+1);
//        }
//        return result;
    return accommodationService.findAll().stream()
            .collect(Collectors.groupingBy(
                    Accommodation::getCategory,
                    Collectors.counting()
                    
            ));
    }

    @Override
    public Optional<DisplayAccommodationFlowDto> findByIdFlow(Long id) {
        return accommodationService.findByIdFlow(id).map(DisplayAccommodationFlowDto::from);

    }


}
