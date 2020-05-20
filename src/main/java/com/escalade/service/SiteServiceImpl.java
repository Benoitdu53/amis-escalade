package com.escalade.service;

import com.escalade.dao.SiteDao;
import com.escalade.model.Site;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * @Autowired permet l'injection de dépendances entre les beans de l'application
 *              Spring va tout faire -> Création du bean, le chercher, l'injecter automatiquement, ...
 * @Service déclare un bean de service, (bean de la couche métier), son nom étant passé en paramètre
 */

@Service
public class SiteServiceImpl implements SiteService
{
    @Autowired
    private SiteDao siteDao;

    /**
     *
     * @return une list de site qui est Cast en Iterator
     */
    @Override
    public List<Site> getSites()
    {
        return StreamSupport.stream(siteDao.findAll().spliterator(), false)
                        .collect(Collectors.toList());

    }

    /**
     *
     * @return la liste des pays
     */
    @Override
    public List<String> getPays()
    {
        return siteDao.findDistinctPays();
    }

    /**
     *
     * @return la liste des cotations minimums
     */
    @Override
    public List<String> getCotationMin()
    {
        return siteDao.findDistinctCotationMin();
    }

    /**
     *
     * @return la liste des types
     */
    @Override
    public List<String> getType()
    {
        return siteDao.findDistinctType();
    }

    /**
     *
     * @param pays
     * @param cotationMin
     * @param type
     * @return la liste selon les critères reçus
     */
    @Override
    public List<Site> getSearchSites(String pays, int cotationMin, String type)
    {
        return StreamSupport.stream(siteDao.findByPaysAndCotationMinAndType(pays, cotationMin, type).spliterator(), false)
                .collect(Collectors.toList());
    }
}
