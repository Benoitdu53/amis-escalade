package com.escalade.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class SiteDaoImpl {
    private static final String HQL_SELECT_SITE ="SELECT s FROM SiteEscalade s";
    private static final String PARAM_SITE ="site";

    // Injection du manager, qui s'occupe de la connexion à la BDD
    @PersistenceContext( unitName = "SITE_ESCALADE")
    private EntityManager entityManager;

    // Afficher les sites d'escalade
    public SiteEscalade listSites(){
        SiteEscalade siteEscalade = null;
        Query query=entityManager.createQuery(HQL_SELECT_SITE);
            siteEscalade =(SiteEscalade) query.getResultList();

        return siteEscalade;
    }
}
