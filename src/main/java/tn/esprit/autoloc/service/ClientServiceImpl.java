package tn.esprit.autoloc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Client;
import tn.esprit.autoloc.repository.IClientRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements IClientService {
    private final IClientRepository repo;

    public List<Client> findAll() { return repo.findAll(); }
    public Client findById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Client introuvable : " + id));
    }
    public Client save(Client c) { return repo.save(c); }
    public Client update(Long id, Client c) {
        Client x = findById(id);
        x.setNom(c.getNom());
        x.setPrenom(c.getPrenom());
        x.setEmail(c.getEmail());
        x.setTelephone(c.getTelephone());
        x.setNumPermis(c.getNumPermis());
        x.setDateInscription(c.getDateInscription());
        return repo.save(x);
    }
    public void delete(Long id) { repo.deleteById(id); }
}
