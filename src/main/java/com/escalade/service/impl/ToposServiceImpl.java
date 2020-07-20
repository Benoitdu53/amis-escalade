package com.escalade.service.impl;

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




    /**
     *          On récupère les topos de l'utilisateur
     * @param pseudo
     * @return
     */
    @Override
    public List<Topos> getToposByPseudo(String pseudo) {

        return toposDao.getToposByPseudo(pseudo);
    }




    /**
     *          Récupère les topos de l'utilisateur
     * @param pseudo
     * @param topos
     */
    @Override
    public void insertToposByUtilisateur(String pseudo, Topos topos)
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
    public List<Topos> getAllToposNotPseudo(final String pseudo)
    {

        return toposDao.getAllToposNotPseudo(pseudo);
    }

}
