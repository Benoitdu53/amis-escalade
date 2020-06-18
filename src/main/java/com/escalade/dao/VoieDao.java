package com.escalade.dao;

import com.escalade.model.Voie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VoieDao extends CrudRepository<Voie, Long>
{
    List<Voie> getVoieBySecteurId(@Param("idSecteur") Long idSecteur);
}
