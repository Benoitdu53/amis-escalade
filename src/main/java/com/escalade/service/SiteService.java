package com.escalade.service;

import com.escalade.model.Site;

import java.util.List;
import java.util.Optional;

public interface SiteService
{
    List<Site> getSites();
    List<String> getPays();
    List<String> getCotationMin();
    List<String> getType();
    List<Site> getSearchSites(String pays, int cotationMin, String type);
    void insertSite(Site newSite);
    Optional<Site> getSite(Long id);
}
