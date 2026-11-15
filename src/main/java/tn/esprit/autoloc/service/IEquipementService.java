package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Equipement;

import java.util.List;

public interface IEquipementService {
    List<Equipement> findAll();
    Equipement findById(Long id);
    Equipement save(Equipement e);
    Equipement update(Long id, Equipement e);
    void delete(Long id);
}