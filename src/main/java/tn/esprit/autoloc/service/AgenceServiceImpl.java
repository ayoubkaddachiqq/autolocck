package tn.esprit.autoloc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.repository.IAgenceRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AgenceServiceImpl implements IAgenceService {
    private final IAgenceRepository repo;

    public List<Agence> findAll() { return repo.findAll(); }
    public Agence findById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Agence introuvable : " + id));
    }
    public Agence save(Agence a) { return repo.save(a); }
    public Agence update(Long id, Agence a) {
        Agence e = findById(id);
        e.setNom(a.getNom());
        e.setVille(a.getVille());
        e.setAdresse(a.getAdresse());
        e.setTelephone(a.getTelephone());
        return repo.save(e);
    }
    public void delete(Long id) { repo.deleteById(id); }
}