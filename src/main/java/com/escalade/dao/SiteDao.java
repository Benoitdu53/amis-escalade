package com.escalade.dao;

import com.escalade.model.Site;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SiteDao extends CrudRepository<Site, Long>
{
}
