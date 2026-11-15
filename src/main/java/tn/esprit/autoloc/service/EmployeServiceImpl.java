package tn.esprit.autoloc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Employe;
import tn.esprit.autoloc.repository.IEmployeRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeServiceImpl implements IEmployeService {
    private final IEmployeRepository repo;

    public List<Employe> findAll() { return repo.findAll(); }
    public Employe findById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Employe introuvable : " + id));
    }
    public Employe save(Employe e) { return repo.save(e); }
    public Employe update(Long id, Employe e) {
        Employe x = findById(id);
        x.setNom(e.getNom());
        x.setPrenom(e.getPrenom());
        x.setRole(e.getRole());
        return repo.save(x);
    }
    public void delete(Long id) { repo.deleteById(id); }
}
