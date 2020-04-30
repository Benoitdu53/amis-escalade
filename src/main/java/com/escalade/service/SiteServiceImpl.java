package com.escalade.service;

import com.escalade.dao.ISiteDao;
import com.escalade.model.SiteEscalade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SiteServiceImpl implements ISiteService
{
    @Autowired
    ISiteDao siteDao;

    @Override
    public List<SiteEscalade> getAllSites()
    {
        return null;
    }
}
