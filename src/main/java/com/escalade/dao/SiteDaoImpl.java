package com.escalade.dao;

import com.escalade.entities.SiteEscalade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class SiteDaoImpl implements ISiteDao {
    private static final String HQL_SELECT_SITE ="SELECT s FROM SiteEscalade s";

    // Injection du manager, qui s'occupe de la connexion à la BDD
    @PersistenceContext( unitName = "SITE_ESCALADE")
    private EntityManager entityManager;

    @Override
    public List<SiteEscalade> listSite()
    {
        Query query = entityManager.createQuery(HQL_SELECT_SITE,SiteEscalade.class);
        return query.getResultList();
    }
}
