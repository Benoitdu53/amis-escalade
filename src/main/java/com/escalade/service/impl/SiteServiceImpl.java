package com.escalade.service.impl;

import com.escalade.dao.SiteDao;
import com.escalade.model.Site;
import com.escalade.model.Utilisateur;
import com.escalade.service.contract.SiteService;
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

    // ----- Injection des dépendances ----- //

    private final SiteDao siteDao;
    @Autowired
    public SiteServiceImpl(SiteDao siteDao){
        this.siteDao = siteDao;
    }




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
    public List<String> getDepartement()
    {
        return siteDao.findDistinctDepartement();
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
     *      Retourne le nom des sites
     * @return
     */
    @Override
    public List<Site> getNomSite()
    {
        return siteDao.getDistinctNomSite();
    }

    /**
     *
     * @param pays
     * @param departement
     * @param type
     * @return la liste selon les critères reçus
     */
    @Override
    public List<Site> getSearchSites(String pays, String departement, String type)
    {
        return StreamSupport.stream(siteDao.searchSite(pays, departement, type).spliterator(), false)
                .collect(Collectors.toList());
    }




    /**
     *          Retourne la liste des sites selon la saisie
     * @param saisie
     * @return
     */
    @Override
    public List<Site> getSiteBySaisie(String saisie)
    {
        saisie = saisie.replaceAll("\\s","");
        saisie = saisie+"%";
        return siteDao.getSiteBySaisie(saisie);
    }




    /**
     *          Ajoute un site
     * @param newSite
     * @param utilisateur
     */
    @Override
    public void insertSite(Site newSite, final Utilisateur utilisateur)
    {
        newSite.setUtilisateur(utilisateur);
        siteDao.save(newSite);
    }




    /**
     *          Récupère un site par son id
     * @param id
     * @return
     */
    @Override
    public Site getSiteById(Long id)
    {
        return siteDao.getSiteById(id);
    }




    /**
     *          Supprime un site par son id
     * @param idSite
     */
    @Override
    public void deleteSiteById(final Long idSite)
    {
        siteDao.deleteById(idSite);
    }




    /**
     *          Taguer un site
     * @param idSite
     */
    @Override
    public void taguerSite(final Long idSite)
    {
        siteDao.taguerSite(idSite);
    }



    /**
     *          Supprime le tague d'un site
     * @param idSite
     */
    @Override
    public void deleteTagueSite(final Long idSite)
    {
        siteDao.deleteTagueSite(idSite);
    }
}
