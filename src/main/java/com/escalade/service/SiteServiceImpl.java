package com.escalade.service;

import com.escalade.dao.ISiteDao;
import com.escalade.model.SiteEscalade;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named("siteService")
public class SiteServiceImpl implements ISiteService
{
    @Autowired
    private ISiteDao iSiteDao;

    @Override
    public List<SiteEscalade> getAllSites()
    {
        return iSiteDao.findAll();
    }
}
