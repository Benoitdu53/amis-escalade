package com.escalade.dao;

import com.escalade.model.Secteur;
import com.escalade.model.Voie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VoieDao extends CrudRepository<Voie, Long>
{
    @Query("SELECT v FROM Voie v WHERE v.secteur = :secteur")
    List<Voie> getVoieBySecteurId(@Param("secteur")Secteur secteur);

    @Query("SELECT v FROM Voie v WHERE v.id = :idVoie")
    Voie getVoieById(@Param("idVoie") Long idVoie);
}
