package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Paiement;

import java.util.List;

public interface IPaiementService {
    List<Paiement> findAll();
    Paiement findById(Long id);
    Paiement save(Paiement p);
    Paiement update(Long id, Paiement p);
    void delete(Long id);
}