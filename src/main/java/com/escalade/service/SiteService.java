package com.escalade.service;

import com.escalade.model.Site;

import java.util.List;

public interface SiteService
{
    /**
     *
     * @return tout les sites
     */
    List<Site> getSites();
    List<Site> getSearchSites(String nom);
}
