//package mk.ukim.finki.lab1b.web;
//
//import io.swagger.v3.oas.annotations.tags.Tag;
//import mk.ukim.finki.lab1b.model.Accommodation;
//import mk.ukim.finki.lab1b.model.Country;
//import mk.ukim.finki.lab1b.model.Dto.AccommodationDto;
//import mk.ukim.finki.lab1b.model.Dto.CountryDto;
//import mk.ukim.finki.lab1b.service.AccommodationService;
//import mk.ukim.finki.lab1b.service.CountryService;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/country")
//@Tag(name = "Country-Controller")
//
//public class CountryController {
//
//    private final CountryService countryService;
//
//    public CountryController(CountryService countryService) {
//        this.countryService = countryService;
//    }
//
//    @GetMapping
//    public List<Country> findAll() {
//        return countryService.findAll();
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Country> findById(@PathVariable Long id) {
//        return countryService.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
//    }
//
//    @PostMapping("/add")
//    public ResponseEntity<Country> save(@RequestBody CountryDto countryDto) {
//        return countryService.save(countryDto)
//                .map(ResponseEntity::ok)
//                .orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//    @PutMapping("/edit/{id}")
//    public ResponseEntity<Country> update(@PathVariable Long id, @RequestBody CountryDto countryDto) {
//        return countryService.update(id, countryDto)
//                .map(ResponseEntity::ok)
//                .orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<Void> delete(@PathVariable Long id) {
//        if (countryService.findById(id).isPresent()) {
//            countryService.deleteById(id);
//            return ResponseEntity.ok().build();
//        }
//        return ResponseEntity.notFound().build();
//    }
//}
