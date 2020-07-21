package com.escalade.dao;

import com.escalade.model.Reservation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationDao extends CrudRepository<Reservation, Long> {

}
