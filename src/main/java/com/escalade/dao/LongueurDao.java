package com.escalade.dao;

import com.escalade.model.Longueur;
import com.escalade.model.Voie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LongueurDao extends CrudRepository<Longueur, Long>
{
    @Query("SELECT l FROM Longueur l WHERE l.voie = :Voie")
    List<Longueur> getLongueurByVoieId(@Param("Voie")Voie voie);

    @Query("SELECT l FROM Longueur l where l.voie.id = :idVoie")
    List<Longueur> getLongueursByIdVoie(@Param("idVoie") Long idVoie);
}
