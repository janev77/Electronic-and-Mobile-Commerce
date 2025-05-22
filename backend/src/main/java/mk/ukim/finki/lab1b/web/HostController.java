package mk.ukim.finki.lab1b.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import mk.ukim.finki.lab1b.dto.CreateHostDto;
import mk.ukim.finki.lab1b.dto.DisplayHostDto;
import mk.ukim.finki.lab1b.model.Projections.HostProjection;
import mk.ukim.finki.lab1b.service.application.CountryApplicationService;
import mk.ukim.finki.lab1b.service.application.HostApplicationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/host")
@Tag(name = "Host-Controller", description = "Endpoints for CRUD operations for host")

public class HostController {

    private final HostApplicationService hostApplicationService;
    private final CountryApplicationService countryApplicationService;

    public HostController(HostApplicationService hostApplicationService, CountryApplicationService countryApplicationService) {

        this.hostApplicationService = hostApplicationService;
        this.countryApplicationService = countryApplicationService;
    }

    @GetMapping
    @Operation(summary = "List all hosts", description = "This endpoint can list all available hosts.")

    public List<DisplayHostDto> findAll() {
        return hostApplicationService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "List host by id", description = "This endpoint can list specific host by id.")

    public ResponseEntity<DisplayHostDto> findById(@PathVariable Long id) {
        return hostApplicationService.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    @Operation(summary = "Add new host", description = "This endpoint can add brand new host.")

    public ResponseEntity<DisplayHostDto> save(@RequestBody CreateHostDto createHostDto) {
        return hostApplicationService.save(createHostDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/edit/{id}")
    @Operation(summary = "Edit host by id", description = "This endpoint can edit specific host by id.")

    public ResponseEntity<DisplayHostDto> update(@PathVariable Long id, @RequestBody CreateHostDto createHostDto) {
        return hostApplicationService.update(id, createHostDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete host by id", description = "This endpoint can delete specific host by id.")

    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (hostApplicationService.findById(id).isPresent()) {
            hostApplicationService.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }


    @GetMapping("/by-country")
    @Operation(summary = "Get number of hosts per country", description = "This endpoint returns the number of hosts for each country.")
    public ResponseEntity<?> numOfHostsPerCountry() {
        return ResponseEntity.status(HttpStatus.OK).body(countryApplicationService.findAllHostsPerCountry());
    }

    @GetMapping("/by-country/{id}")
    @Operation(summary = "Get number of hosts per country by id", description = "This endpoint returns the number of hosts for each country with specific id.")
    public ResponseEntity<?> numOfHostsPerCountryId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(countryApplicationService.findHostPerCountry(id));
    }

    @GetMapping("/names")
    @Operation(summary = "Get names of all hosts", description = "Returns first and last names of all hosts.")
    public ResponseEntity<List<HostProjection>> namesAndSurnamesOfHosts() {
        return ResponseEntity.ok(hostApplicationService.getAllHostNames());
    }




}
