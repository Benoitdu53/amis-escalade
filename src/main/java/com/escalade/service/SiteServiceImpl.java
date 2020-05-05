package com.escalade.service;

import com.escalade.dao.ISiteDao;
import com.escalade.model.SiteEscalade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class SiteServiceImpl implements ISiteService
{
    @Autowired
    private ISiteDao iSiteDao;

    @Override
    @Transactional
    public List<SiteEscalade> getAllSites()
    {
        return iSiteDao.findAll();
    }
}
