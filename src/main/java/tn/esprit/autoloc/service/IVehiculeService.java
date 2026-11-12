package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.StatutVehicule;
import tn.esprit.autoloc.domain.Vehicule;

import java.util.List;

public interface IVehiculeService {
    List<Vehicule> findAll();
    Vehicule findById(Long id);
    Vehicule save(Vehicule v);
    Vehicule update(Long id, Vehicule v);
    void delete(Long id);
    List<Vehicule> findByStatut(StatutVehicule statut);
}
