package tn.esprit.autoloc.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Maintenance;
import tn.esprit.autoloc.service.IMaintenanceService;

import java.util.List;

@RestController
@RequestMapping("/api/maintenances")
@RequiredArgsConstructor
public class MaintenanceController {
    private final IMaintenanceService service;

    @GetMapping
    public ResponseEntity<List<Maintenance>> getAll() { return ResponseEntity.ok(service.findAll()); }

    @GetMapping("/{id}")
    public ResponseEntity<Maintenance> getById(@PathVariable Long id) { return ResponseEntity.ok(service.findById(id)); }

    @PostMapping
    public ResponseEntity<Maintenance> create(@RequestBody Maintenance m) { return ResponseEntity.ok(service.save(m)); }

    @PutMapping("/{id}")
    public ResponseEntity<Maintenance> update(@PathVariable Long id, @RequestBody Maintenance m) {
        return ResponseEntity.ok(service.update(id, m));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok("Maintenance supprimée");
    }
}
