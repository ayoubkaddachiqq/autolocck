package tn.esprit.autoloc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Paiement;
import tn.esprit.autoloc.repository.IPaiementRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaiementServiceImpl implements IPaiementService {
    private final IPaiementRepository repo;

    public List<Paiement> findAll() { return repo.findAll(); }
    public Paiement findById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Paiement introuvable : " + id));
    }
    public Paiement save(Paiement p) { return repo.save(p); }
    public Paiement update(Long id, Paiement p) {
        Paiement x = findById(id);
        x.setMontant(p.getMontant());
        x.setDatePaiement(p.getDatePaiement());
        x.setModePaiement(p.getModePaiement());
        return repo.save(x);
    }
    public void delete(Long id) { repo.deleteById(id); }
}
