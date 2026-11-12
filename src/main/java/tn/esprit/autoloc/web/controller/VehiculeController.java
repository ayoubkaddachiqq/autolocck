package tn.esprit.autoloc.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.StatutVehicule;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.service.IVehiculeService;

import java.util.List;

@RestController
@RequestMapping("/api/vehicules")
@RequiredArgsConstructor
public class VehiculeController {

    private final IVehiculeService vehiculeService;

    @GetMapping
    public ResponseEntity<List<Vehicule>> getAll() {
        return ResponseEntity.ok(vehiculeService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehicule> getById(@PathVariable Long id) {
        return ResponseEntity.ok(vehiculeService.findById(id));
    }

    @GetMapping("/statut/{statut}")
    public ResponseEntity<List<Vehicule>> getByStatut(@PathVariable StatutVehicule statut) {
        return ResponseEntity.ok(vehiculeService.findByStatut(statut));
    }

    @PostMapping
    public ResponseEntity<Vehicule> create(@RequestBody Vehicule v) {
        return ResponseEntity.ok(vehiculeService.save(v));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vehicule> update(@PathVariable Long id, @RequestBody Vehicule v) {
        return ResponseEntity.ok(vehiculeService.update(id, v));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        vehiculeService.delete(id);
        return ResponseEntity.ok("Vehicule supprimé");
    }
}