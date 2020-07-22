package com.escalade.service.contract;

import com.escalade.model.Reservation;

import java.util.List;

public interface ReservationService {

    void reservationOn(Long idToposDispo, String pseudo);
    List<Reservation> getReservationByUtilisateur(String pseudo);
}
