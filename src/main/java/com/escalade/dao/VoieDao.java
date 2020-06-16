package com.escalade.dao;

import com.escalade.model.Voie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VoieDao extends CrudRepository<Voie, Long>
{
    @Query("SELECT v FROM Site s JOIN Voie v WHERE s.id = :id") // TODO Ne fonctionne pas 
    List<Voie> getVoieByidSite(@Param("id") Long id);
}
