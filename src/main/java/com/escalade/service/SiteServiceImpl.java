package com.escalade.service;

import com.escalade.dao.SiteDao;
import com.escalade.model.Site;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class SiteServiceImpl implements SiteService
{
    @Autowired
    private SiteDao siteDao;

    @Override
    public List<Site> getSites()
    {
        return
                StreamSupport.stream(siteDao.findAll().spliterator(), false)
                        .collect(Collectors.toList());

    }
}
