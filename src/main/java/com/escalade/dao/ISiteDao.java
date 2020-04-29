package com.escalade.dao;

import com.escalade.entities.SiteEscalade;

import javax.ejb.Local;
import java.util.List;
@Local
public interface ISiteDao
{
    public List<SiteEscalade> listSite();
}
