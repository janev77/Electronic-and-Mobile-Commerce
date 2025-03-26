package mk.ukim.finki.lab1b.web;

import io.swagger.v3.oas.annotations.tags.Tag;
import mk.ukim.finki.lab1b.model.Accommodation;
import mk.ukim.finki.lab1b.model.Dto.AccommodationDto;
import mk.ukim.finki.lab1b.service.AccommodationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accommodations")
@Tag(name = "Accommodation-Controller")

public class AccommodationController {

    private final AccommodationService accommodationService;

    public AccommodationController(AccommodationService accommodationService) {
        this.accommodationService = accommodationService;
    }

    @GetMapping
    public List<Accommodation> findAll() {
        return accommodationService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Accommodation> findById(@PathVariable Long id) {
        return accommodationService.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<Accommodation> save(@RequestBody AccommodationDto accommodationDto) {
        return accommodationService.save(accommodationDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Accommodation> update(@PathVariable Long id, @RequestBody AccommodationDto accommodationDto) {
        return accommodationService.update(id, accommodationDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (accommodationService.findById(id).isPresent()) {
            accommodationService.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}/rent")
    public ResponseEntity<Accommodation> rentAccommodation(@PathVariable Long id) {
        return this.accommodationService.isRented(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }
}
