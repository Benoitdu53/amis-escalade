package com.escalade.dao;

import com.escalade.model.SiteEscalade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SiteDaoImpl implements ISiteDao {

    @Autowired

    @Override
    public List<SiteEscalade> getAllSites()
    {
        return null;
    }

}
