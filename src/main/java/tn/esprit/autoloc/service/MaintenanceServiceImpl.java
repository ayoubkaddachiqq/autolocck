package tn.esprit.autoloc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Maintenance;
import tn.esprit.autoloc.repository.IMaintenanceRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MaintenanceServiceImpl implements IMaintenanceService {
    private final IMaintenanceRepository repo;

    public List<Maintenance> findAll() { return repo.findAll(); }
    public Maintenance findById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Maintenance introuvable : " + id));
    }
    public Maintenance save(Maintenance m) { return repo.save(m); }
    public Maintenance update(Long id, Maintenance m) {
        Maintenance x = findById(id);
        x.setDateDebut(m.getDateDebut());
        x.setDateFin(m.getDateFin());
        x.setDescription(m.getDescription());
        return repo.save(x);
    }
    public void delete(Long id) { repo.deleteById(id); }
}
