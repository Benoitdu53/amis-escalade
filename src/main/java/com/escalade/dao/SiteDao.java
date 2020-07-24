package com.escalade.dao;

import com.escalade.model.Site;
import com.escalade.model.Topos;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Interface qui étend le CruRepository ( méthode findAll, saveAll, etc...)
 */
@Repository
public interface SiteDao extends CrudRepository<Site, Long>
{

    @Query("SELECT DISTINCT s.pays FROM Site s")
    List<String> findDistinctPays();

    @Query("SELECT DISTINCT s.departement FROM Site s")
    List<String> findDistinctDepartement();

    @Query("SELECT DISTINCT s.type FROM Site s")
    List<String> findDistinctType();

    @Query("SELECT s FROM Site s WHERE (:pays='' or s.pays = :pays) AND (:departement='' or s.departement =:departement) AND (:type='' or s.type=:type)")
    List<Site> searchSite(@Param ("pays") String pays, @Param("departement") String departement, @Param("type") String type);

    @Query("SELECT s FROM Site s WHERE s.id = :id")
    Site getSiteById(@Param("id") Long id);

    @Query("SELECT DISTINCT s.nom FROM Site s")
    List<Site> getDistinctNomSite();

}
