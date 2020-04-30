package com.escalade.dao;

import com.escalade.model.SiteEscalade;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISiteDao
{
    public List<SiteEscalade> getAllSites();
}
