package com.escalade.dao;

import com.escalade.model.Topos;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToposDao extends CrudRepository<Topos, Long> {

    @Query("SELECT t FROM Topos t Where t.id= :idUtilisateur")
    List<Topos> getToposByUtilisateur(@Param("idUtilisateur") Long idUtilisateur);

}
