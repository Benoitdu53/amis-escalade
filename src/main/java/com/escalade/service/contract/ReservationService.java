package com.escalade.service.contract;

import com.escalade.model.Reservation;
import com.escalade.model.Topos;

import java.util.List;

public interface ReservationService {

    void reservationOn(Long idToposDispo, String pseudo);
    List<Reservation> getDemandeReçus(String pseudo);
    List<Reservation> getDemandeExpedie(String pseudo);
    void deleteReservation(Long idReservation, Long idTopos);
    void updateReservation(Long idReservation, Long idTopos);
}
