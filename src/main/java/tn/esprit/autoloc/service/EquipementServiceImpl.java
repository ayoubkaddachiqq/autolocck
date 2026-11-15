package tn.esprit.autoloc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Equipement;
import tn.esprit.autoloc.repository.IEquipementRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EquipementServiceImpl implements IEquipementService {
    private final IEquipementRepository repo;

    public List<Equipement> findAll() { return repo.findAll(); }
    public Equipement findById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Equipement introuvable : " + id));
    }
    public Equipement save(Equipement e) { return repo.save(e); }
    public Equipement update(Long id, Equipement e) {
        Equipement x = findById(id);
        x.setLibelle(e.getLibelle());
        return repo.save(x);
    }
    public void delete(Long id) { repo.deleteById(id); }
}