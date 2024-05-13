package jabbour.younes.jabbour.web;

import jabbour.younes.jabbour.DTOs.CreatedSalle.CreatedSalle;
import jabbour.younes.jabbour.DTOs.Employe.EmployeDTO;
import jabbour.younes.jabbour.entity.Salle;
import jabbour.younes.jabbour.service.interfaces.SalleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/salle")
public class SalleRestController {
    private final SalleService salleService;

    @GetMapping("")
    public ResponseEntity<List<Salle>> getAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size) {
        return ResponseEntity.ok(salleService.getAllSalles(page, size).getContent());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Salle> getOne(@RequestParam Long id) {
        return ResponseEntity.ok(salleService.findSalleById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@RequestParam Long id) {
        salleService.deleteSalle(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Salle> update(@PathVariable Long id, @RequestBody Salle salle) {
        salle.setId(id);
        return ResponseEntity.ok(salleService.updateSalle(salle));
    }

    @PostMapping("")
    public ResponseEntity<Salle> create(@RequestBody CreatedSalle salle) {
        return ResponseEntity.ok(salleService.createSalle(salle));
    }
}
