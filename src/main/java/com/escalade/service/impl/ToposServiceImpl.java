package com.escalade.service.impl;

import com.escalade.dao.ReservationDao;
import com.escalade.dao.SiteDao;
import com.escalade.dao.ToposDao;
import com.escalade.dao.UtilisateurDao;
import com.escalade.model.Topos;
import com.escalade.model.Utilisateur;
import com.escalade.service.contract.ToposService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToposServiceImpl implements ToposService
{

    // ----- Injection des dépendances ----- //
    @Autowired
    private ToposDao toposDao;

    @Autowired
    private UtilisateurDao utilisateurDao;

    @Autowired
    private ReservationDao reservationDao;

    @Autowired
    private SiteDao siteDao;




    /**
     *          On récupère les topos de l'utilisateur
     *
     * @param pseudo
     * @return
     */
    @Override
    public List<Topos> getToposByPseudo( String pseudo) {
        return toposDao.getToposByPseudo(pseudo);
    }




    /**
     *          On ajoute les topos
     * @param topos
     * @param pseudo
     */
    @Override
    public void insertToposByUtilisateur(Topos topos, String pseudo)
    {
        Utilisateur utilisateur = utilisateurDao.getUtilisateurByPseudo(pseudo);
        topos.setUtilisateur(utilisateur);

        toposDao.save(topos);

    }




    /**
     *          Récupère les topos qui ne sont pas de l'utilisateur
     * @param pseudo
     * @return
     */
    @Override
    public List<Topos> getToposDispos(String pseudo)
    {
        return toposDao.getToposDispos(pseudo);
    }




    /**
     *      Mettre un topo dispo
     * @param idTopo
     */
    @Override
    public void changeDispoTopo(final Long idTopo)
    {
        Topos topo =toposDao.getToposById(idTopo);
        toposDao.updateToposFalse(topo);
    }




    /**
     *
     * @param idTopo
     */
    @Override
    public void deleteTopo(final Long idTopo)
    {
        toposDao.deleteById(idTopo);
    }

}
