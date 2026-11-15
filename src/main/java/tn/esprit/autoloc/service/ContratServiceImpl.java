package tn.esprit.autoloc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Contrat;
import tn.esprit.autoloc.repository.IContratRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContratServiceImpl implements IContratService {
    private final IContratRepository repo;

    public List<Contrat> findAll() { return repo.findAll(); }
    public Contrat findById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Contrat introuvable : " + id));
    }
    public Contrat save(Contrat c) { return repo.save(c); }
    public Contrat update(Long id, Contrat c) {
        Contrat x = findById(id);
        x.setDateSignature(c.getDateSignature());
        x.setMontantTotal(c.getMontantTotal());
        x.setValide(c.isValide());
        return repo.save(x);
    }
    public void delete(Long id) { repo.deleteById(id); }
}