package com.escalade.dao;

import com.escalade.model.Secteur;
import com.escalade.model.Site;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SecteurDao extends CrudRepository <Secteur, Long>
{
    @Query("SELECT r FROM Secteur r WHERE r.site = :site ")
    List<Secteur> getSectorByIdSite(@Param("site") Site site);

    @Query("SELECT r FROM Secteur r WHERE r.id = :id")
    Secteur getSectorById(@Param("id") Long id);
}
