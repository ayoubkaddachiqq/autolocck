package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Contrat;

import java.util.List;

public interface IContratService {
    List<Contrat> findAll();
    Contrat findById(Long id);
    Contrat save(Contrat c);
    Contrat update(Long id, Contrat c);
    void delete(Long id);
}