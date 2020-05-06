package com.escalade.dao;

import com.escalade.model.Site;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface qui etend le CruRepository ( méthode findAll, saveAll, etc...)
 */
@Repository
public interface SiteDao extends CrudRepository<Site, Long>
{
}
