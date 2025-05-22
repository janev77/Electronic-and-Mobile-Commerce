package mk.ukim.finki.lab1b.dto;

import mk.ukim.finki.lab1b.model.Domain.Accommodation;
import mk.ukim.finki.lab1b.model.Domain.Country;
import mk.ukim.finki.lab1b.model.Domain.Host;
import mk.ukim.finki.lab1b.model.Enumerations.Category;

import java.util.List;
import java.util.stream.Collectors;

public record DisplayAccommodationFlowDto(
        Long id,
        String name,
        Category category,
        Host host,
        Integer numRooms,
        Country country
) {
    public static DisplayAccommodationFlowDto from(Accommodation accommodation) {
        return new DisplayAccommodationFlowDto(
                accommodation.getId(),
                accommodation.getName(),
                accommodation.getCategory(),
                accommodation.getHost(),              // Only this is needed
                accommodation.getNumRooms(),
                accommodation.getHost().getCountry()
        );
    }

    public static List<DisplayAccommodationFlowDto> from(List<Accommodation> accommodations) {
        return accommodations.stream().map(DisplayAccommodationFlowDto::from).collect(Collectors.toList());
    }

    public Accommodation toAccommodation(Category category, Host host) {
        return new Accommodation(name, category, host, numRooms);
    }
}
