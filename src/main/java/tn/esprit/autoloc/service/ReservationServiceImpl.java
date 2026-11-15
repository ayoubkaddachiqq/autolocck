package tn.esprit.autoloc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Reservation;
import tn.esprit.autoloc.repository.IReservationRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements IReservationService {
    private final IReservationRepository repo;

    public List<Reservation> findAll() { return repo.findAll(); }
    public Reservation findById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Reservation introuvable : " + id));
    }
    public Reservation save(Reservation r) { return repo.save(r); }
    public Reservation update(Long id, Reservation r) {
        Reservation x = findById(id);
        x.setDateDebut(r.getDateDebut());
        x.setDateFin(r.getDateFin());
        x.setStatut(r.getStatut());
        return repo.save(x);
    }
    public void delete(Long id) { repo.deleteById(id); }
}
