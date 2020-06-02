package com.escalade.service;

import com.escalade.model.Site;

import java.util.List;

public interface SiteService
{
    List<Site> getSites();
    List<String> getPays();
    List<String> getCotationMin();
    List<String> getType();
    List<Site> getSearchSites(String pays, int cotationMin, String type);
    void insertSite(Site newSite);
}
