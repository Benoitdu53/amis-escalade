package com.escalade.dao;

import com.escalade.model.Topos;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToposDao extends CrudRepository<Topos, Long> {

    @Query("SELECT t FROM Topos t WHERE t.utilisateur.pseudo = :pseudo ")
    List<Topos> getToposByPseudo(@Param("pseudo") String pseudo);

    @Query("SELECT t FROM Topos t WHERE t.utilisateur.pseudo NOT LIKE :pseudo")
    List<Topos> getAllToposNotPseudo(@Param("pseudo") String pseudo);

    @Query("SELECT t FROM Topos t Where t.id = :idToposDispo")
    Topos getToposById(@Param("idToposDispo") Long idToposDispo);

    @Query("SELECT t FROM Topos t WHERE (t.utilisateur.pseudo NOT LIKE :pseudo) AND (t.isReserve = false )")
    List<Topos> getToposDispos(@Param("pseudo") String pseudo);

    @Modifying
    @Query("UPDATE Topos t set t.isReserve=false where t = :topos")
    void updateTopos(@Param("topos") Topos topos);

}
