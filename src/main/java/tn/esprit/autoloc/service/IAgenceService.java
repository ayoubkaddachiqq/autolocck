package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Agence;

import java.util.List;

public interface IAgenceService {
    List<Agence> findAll();
    Agence findById(Long id);
    Agence save(Agence a);
    Agence update(Long id, Agence a);
    void delete(Long id);
}