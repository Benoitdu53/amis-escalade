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

    @Query("SELECT t FROM Topos t JOIN t.reservationList r WHERE (r.status='En attente de réponse') AND (r.utilisateur.pseudo =:pseudo)")
    List<Topos> getReservationByPseudoAttente(@Param("pseudo") String pseudo);

    @Query("SELECT t FROM Topos t WHERE (t.utilisateur.pseudo NOT LIKE :pseudo)")
    List<Topos> getReservationByPseudoIsNull(@Param("pseudo") String pseudo);

    @Query("SELECT t FROM Topos t JOIN t.reservationList r WHERE (r.status='Accepter') AND (r.utilisateur.pseudo =:pseudo)")
    List<Topos> getReservationByPseudoAccepter(@Param("pseudo") String pseudo);

    @Query("SELECT t FROM Topos t JOIN t.reservationList r WHERE (r.status='En attente de réponse') AND (r.utilisateur.pseudo NOT LIKE :pseudo)")
    List<Topos> getReservationAttente(@Param("pseudo") String pseudo);
}
