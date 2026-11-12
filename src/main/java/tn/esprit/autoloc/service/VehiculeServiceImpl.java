package tn.esprit.autoloc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.StatutVehicule;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.repository.IVehiculeRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehiculeServiceImpl implements IVehiculeService {

    private final IVehiculeRepository vehiculeRepository;

    public List<Vehicule> findAll() { return vehiculeRepository.findAll(); }

    public Vehicule findById(Long id) {
        return vehiculeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicule introuvable : " + id));
    }

    public Vehicule save(Vehicule v) { return vehiculeRepository.save(v); }

    public Vehicule update(Long id, Vehicule v) {
        Vehicule existing = findById(id);
        existing.setImmatriculation(v.getImmatriculation());
        existing.setMarque(v.getMarque());
        existing.setModele(v.getModele());
        existing.setCategorie(v.getCategorie());
        existing.setTarifJournalier(v.getTarifJournalier());
        existing.setStatut(v.getStatut());
        return vehiculeRepository.save(existing);
    }

    public void delete(Long id) { vehiculeRepository.deleteById(id); }

    public List<Vehicule> findByStatut(StatutVehicule statut) {
        return vehiculeRepository.findByStatut(statut);
    }
}