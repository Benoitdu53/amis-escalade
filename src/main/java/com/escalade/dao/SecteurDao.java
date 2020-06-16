package com.escalade.dao;

import com.escalade.model.Secteur;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SecteurDao extends CrudRepository <Secteur, Long>
{
    @Query("SELECT r FROM Secteur r WHERE r.site.id = :id ")
    List<Secteur> getSectorByIdSite(@Param("id") Long id);

    @Query("SELECT r FROM Secteur r WHERE r.id = :id")
    Secteur getSectorById(@Param("id") Long id);
}
