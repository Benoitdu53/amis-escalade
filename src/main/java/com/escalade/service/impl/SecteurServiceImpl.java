package com.escalade.service.impl;

import com.escalade.dao.SecteurDao;
import com.escalade.model.Secteur;
import com.escalade.model.Site;
import com.escalade.service.contract.SecteurService;
import com.escalade.service.contract.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SecteurServiceImpl implements SecteurService
{
    @Autowired
    private SiteService siteService;

    private final SecteurDao secteurDao;
    @Autowired
    public SecteurServiceImpl(SecteurDao secteurDao){
        this.secteurDao = secteurDao;
    }


    @Override
    public void insertSecteur(final Secteur newSecteur, final Long idSite)
    {
        Site site = siteService.getSiteById(idSite);
        newSecteur.setSite(site);
        secteurDao.save(newSecteur);
    }

    @Override
    public void deleteSecteurById(final Long idSecteur)
    {
        secteurDao.deleteById(idSecteur);
    }

    @Override
    public List<Secteur> getSectorByIdSite(final Long id)
    {
        return secteurDao.getSectorByIdSite(siteService.getSiteById(id));
    }

    @Override
    public Secteur getSectorById(final Long id)
    {
        return secteurDao.getSectorById(id);
    }
}
