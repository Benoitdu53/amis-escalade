package com.escalade.dao;

import com.escalade.model.Reservation;
import com.escalade.model.Topos;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationDao extends CrudRepository<Reservation, Long> {

    @Query("SELECT r FROM Reservation r WHERE r.topos.utilisateur.pseudo = :pseudo")
    List<Reservation> getReservationsRecus(@Param("pseudo") String pseudo);

    @Query("SELECT r FROM Reservation r WHERE r.topos.utilisateur.pseudo NOT LIKE :pseudo")
    List<Reservation> getReservationExpedies(@Param("pseudo") String pseudo);

}
