package mk.ukim.finki.lab1b.web;

import io.swagger.v3.oas.annotations.tags.Tag;

import mk.ukim.finki.lab1b.model.Dto.ReservationDto;
import mk.ukim.finki.lab1b.model.Host;
import mk.ukim.finki.lab1b.model.Reservation;
import mk.ukim.finki.lab1b.service.HostService;
import mk.ukim.finki.lab1b.service.ReservationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservation")
@Tag(name = "Reservation-Controller")

public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {

        this.reservationService = reservationService;
    }

    @GetMapping
    public List<Reservation> findAll() {
        return reservationService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservation> findById(@PathVariable Long id) {
        return reservationService.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<Reservation> save(@RequestBody ReservationDto reservationDto) {
        return reservationService.save(reservationDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Reservation> update(@PathVariable Long id, @RequestBody ReservationDto reservationDto) {
        return reservationService.update(id, reservationDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (reservationService.findById(id).isPresent()) {
            reservationService.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
