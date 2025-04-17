package mk.ukim.finki.lab1b.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import mk.ukim.finki.lab1b.dto.CreateReservationDto;
import mk.ukim.finki.lab1b.dto.DisplayReservationDto;
import mk.ukim.finki.lab1b.service.application.ReservationApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservation")
@Tag(name = "Reservation-Controller", description = "Endpoints for CRUD operations for reservation")

public class ReservationController {

    private final ReservationApplicationService reservationApplicationService;

    public ReservationController(ReservationApplicationService reservationApplicationService) {

        this.reservationApplicationService = reservationApplicationService;
    }

    @GetMapping
    @Operation(summary = "List all reservations", description = "List's all reservations that are available.")
    public List<DisplayReservationDto> findAll() {
        return reservationApplicationService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "List reservation by id", description = "List's reservation that is available by id.")

    public ResponseEntity<DisplayReservationDto> findById(@PathVariable Long id) {
        return reservationApplicationService.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    @Operation(summary = "Add reservation", description = "This endpoint adds brand new reservation.")
    public ResponseEntity<DisplayReservationDto> save(@RequestBody CreateReservationDto createReservationDto) {
        return reservationApplicationService.save(createReservationDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/edit/{id}")
    @Operation(summary = "Edit reservation by id", description = "This endpoint can edit specific reservation by id.")

    public ResponseEntity<DisplayReservationDto> update(@PathVariable Long id, @RequestBody CreateReservationDto createReservationDto) {
        return reservationApplicationService.update(id, createReservationDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete reservation by id", description = "This endpoint can delete specific reservation by id.")

    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (reservationApplicationService.findById(id).isPresent()) {
            reservationApplicationService.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
