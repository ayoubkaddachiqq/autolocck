package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Reservation;

import java.util.List;

public interface IReservationService {
    List<Reservation> findAll();
    Reservation findById(Long id);
    Reservation save(Reservation r);
    Reservation update(Long id, Reservation r);
    void delete(Long id);
}