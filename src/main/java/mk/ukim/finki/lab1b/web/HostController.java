//package mk.ukim.finki.lab1b.web;
//
//import io.swagger.v3.oas.annotations.tags.Tag;
//import mk.ukim.finki.lab1b.model.Dto.HostDto;
//import mk.ukim.finki.lab1b.model.Host;
//import mk.ukim.finki.lab1b.service.HostService;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/host")
//@Tag(name = "Host-Controller")
//
//public class HostController {
//
//    private final HostService hostService;
//
//    public HostController(HostService hostService) {
//        this.hostService = hostService;
//    }
//
//    @GetMapping
//    public List<Host> findAll() {
//        return hostService.findAll();
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Host> findById(@PathVariable Long id) {
//        return hostService.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
//    }
//
//    @PostMapping("/add")
//    public ResponseEntity<Host> save(@RequestBody HostDto hostDto) {
//        return hostService.save(hostDto)
//                .map(ResponseEntity::ok)
//                .orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//    @PutMapping("/edit/{id}")
//    public ResponseEntity<Host> update(@PathVariable Long id, @RequestBody HostDto hostDto) {
//        return hostService.update(id, hostDto)
//                .map(ResponseEntity::ok)
//                .orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<Void> delete(@PathVariable Long id) {
//        if (hostService.findById(id).isPresent()) {
//            hostService.deleteById(id);
//            return ResponseEntity.ok().build();
//        }
//        return ResponseEntity.notFound().build();
//    }
//}
