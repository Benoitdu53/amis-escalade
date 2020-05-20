package com.escalade.dao;

import com.escalade.model.Site;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Interface qui etend le CruRepository ( méthode findAll, saveAll, etc...)
 */
@Repository
public interface SiteDao extends CrudRepository<Site, Long>
{
    @Query("SELECT DISTINCT s.pays FROM Site s")
    List<String> findDistinctPays();

    @Query("SELECT DISTINCT s.cotationMin FROM Site s")
    List<String> findDistinctCotationMin();

    @Query("SELECT DISTINCT s.type FROM Site s")
    List<String> findDistinctType();

    List<Site> findByPaysAndCotationMinAndType(String pays, int cotationMin, String type);
}
