package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Maintenance;

import java.util.List;

public interface IMaintenanceService {
    List<Maintenance> findAll();
    Maintenance findById(Long id);
    Maintenance save(Maintenance m);
    Maintenance update(Long id, Maintenance m);
    void delete(Long id);
}
