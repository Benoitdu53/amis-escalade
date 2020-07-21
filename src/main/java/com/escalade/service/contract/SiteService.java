package com.escalade.service.contract;

import com.escalade.model.Site;

import java.util.List;


public interface SiteService
{
    List<Site> getSites();
    List<String> getPays();
    List<String> getDepartement();
    List<String> getType();
    List<Site> getSearchSites(String pays, String departement, String type);
    void insertSite(Site newSite);
    Site getSiteById(Long id);
    void deleteSiteById(Long idSite);
}