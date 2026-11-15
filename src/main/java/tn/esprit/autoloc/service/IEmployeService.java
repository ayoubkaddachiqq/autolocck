package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Employe;

import java.util.List;

public interface IEmployeService {
    List<Employe> findAll();
    Employe findById(Long id);
    Employe save(Employe e);
    Employe update(Long id, Employe e);
    void delete(Long id);
}
