package mk.ukim.finki.lab1b.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import mk.ukim.finki.lab1b.dto.CreateAccommodationDto;
import mk.ukim.finki.lab1b.dto.DisplayAccommodationDto;
import mk.ukim.finki.lab1b.model.Domain.Accommodation;
import mk.ukim.finki.lab1b.service.application.AccommodationApplicationService;
import mk.ukim.finki.lab1b.service.domain.AccommodationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/accommodations")
@Tag(name = "Accommodation-Controller", description = "Endpoints for CRUD operations for reservation")

public class AccommodationController {

    private final AccommodationApplicationService accommodationApplicationService;
    private final AccommodationService accommodationService;

    public AccommodationController(AccommodationApplicationService accommodationApplicationService, AccommodationService accommodationService) {
        this.accommodationApplicationService = accommodationApplicationService;
        this.accommodationService = accommodationService;
    }

    @GetMapping
    @Operation(summary = "List all accommodations", description = "This endpoint can list all available accommodations.")

    public List<DisplayAccommodationDto> findAll() {
        return accommodationApplicationService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "List accommodation by id", description = "This endpoint can list specific accommodation by id.")

    public ResponseEntity<DisplayAccommodationDto> findById(@PathVariable Long id) {
        return accommodationApplicationService.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    @Operation(summary = "Add accommodation", description = "This endpoint can add brand new accommodation.")

    public ResponseEntity<DisplayAccommodationDto> save(@RequestBody CreateAccommodationDto createAccommodationDto) {
        return accommodationApplicationService.save(createAccommodationDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/edit/{id}")
    @Operation(summary = "Edit accommodation by id", description = "This endpoint can edit specific accommodation by id.")

    public ResponseEntity<DisplayAccommodationDto> update(@PathVariable Long id, @RequestBody CreateAccommodationDto createAccommodationDto) {
        return accommodationApplicationService.update(id, createAccommodationDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete accommodation by id", description = "This endpoint can delete specific accommodation by id.")

    public ResponseEntity<Void> statistic(@PathVariable Long id) {
        if (accommodationApplicationService.findById(id).isPresent()) {
            accommodationApplicationService.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/statistic")
    public HashMap<String,Integer> statistic() {
       return accommodationApplicationService.statisticCategory();
    }

}
