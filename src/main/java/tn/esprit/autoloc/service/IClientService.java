package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Client;

import java.util.List;

public interface IClientService {
    List<Client> findAll();
    Client findById(Long id);
    Client save(Client c);
    Client update(Long id, Client c);
    void delete(Long id);
}
