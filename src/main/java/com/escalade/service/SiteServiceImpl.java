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
}
