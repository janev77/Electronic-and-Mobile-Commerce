package mk.ukim.finki.lab1b.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import mk.ukim.finki.lab1b.dto.CreateReservationDto;
import mk.ukim.finki.lab1b.dto.CreateTemporaryReservationDto;
import mk.ukim.finki.lab1b.dto.DisplayReservationDto;
import mk.ukim.finki.lab1b.dto.DisplayTemporaryReservationDto;
import mk.ukim.finki.lab1b.service.application.ReservationApplicationService;
import mk.ukim.finki.lab1b.service.application.TemporaryApplicationReservationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/temporary")
@Tag(name = "Temporary-Controller", description = "Endpoints for CRUD operations for temporary")

public class TemporaryReservationController {

    private final TemporaryApplicationReservationService temporaryApplicationReservationService;

    public TemporaryReservationController(TemporaryApplicationReservationService temporaryApplicationReservationService) {

        this.temporaryApplicationReservationService = temporaryApplicationReservationService;
    }

//    @GetMapping
//    @Operation(summary = "List all reservations", description = "List's all temporary reservations that are available.")
//    public List<DisplayTemporaryReservationDto> findAll() {
//        return temporaryApplicationReservationService.findAll();
//    }

//    @GetMapping("/{id}")
//    @Operation(summary = "List reservation by id", description = "List's reservation that is available by id.")
//
//    public ResponseEntity<DisplayReservationDto> findById(@PathVariable Long id) {
//        return temporaryApplicationReservationService.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
//    }

//    @PostMapping("/add")
//    @Operation(summary = "Add temporary reservation", description = "This endpoint adds temporary reservation.")
//    public ResponseEntity<DisplayTemporaryReservationDto> save(@RequestBody CreateTemporaryReservationDto createReservationDto) {
//        return temporaryApplicationReservationService.save(createReservationDto)
//                .map(ResponseEntity::ok)
//                .orElseGet(() -> ResponseEntity.notFound().build());
//    }

//    @PutMapping("/edit/{id}")
//    @Operation(summary = "Edit reservation by id", description = "This endpoint can edit specific reservation by id.")
//
//    public ResponseEntity<DisplayReservationDto> update(@PathVariable Long id, @RequestBody CreateReservationDto createReservationDto) {
//        return reservationApplicationService.update(id, createReservationDto)
//                .map(ResponseEntity::ok)
//                .orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//    @DeleteMapping("/delete/{id}")
//    @Operation(summary = "Delete reservation by id", description = "This endpoint can delete specific reservation by id.")
//
//    public ResponseEntity<Void> delete(@PathVariable Long id) {
//        if (reservationApplicationService.findById(id).isPresent()) {
//            reservationApplicationService.deleteById(id);
//            return ResponseEntity.ok().build();
//        }
//        return ResponseEntity.notFound().build();
//    }

    @Operation(summary = "Add temporary reservation")
    @PostMapping("/reservations")
    public ResponseEntity<?> addReservation(@RequestBody CreateTemporaryReservationDto dto) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        Optional<DisplayTemporaryReservationDto> optionalReservation =
                temporaryApplicationReservationService.addTemporaryReservation(dto, username);
        if (optionalReservation.isPresent()) {
            return ResponseEntity.ok(optionalReservation.get());
        } else {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("No rooms available for this accommodation.");
        }
    }

    @Operation(summary = "Get temporary reservations")
    @GetMapping("/reservations/list")
    public List<DisplayTemporaryReservationDto> getTemporaryReservations() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return temporaryApplicationReservationService.getTemporaryReservationsForUser(username);
    }

    @Operation(summary = "Confirm all reservations")
    @PostMapping("/reservations/confirm")
    public void confirmReservations() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        temporaryApplicationReservationService.confirmAllReservationsForUser(username);
    }


}
