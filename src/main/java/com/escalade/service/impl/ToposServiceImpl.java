package com.escalade.service.impl;

import com.escalade.dao.ReservationDao;
import com.escalade.dao.ToposDao;
import com.escalade.dao.UtilisateurDao;
import com.escalade.model.Reservation;
import com.escalade.model.Topos;
import com.escalade.model.Utilisateur;
import com.escalade.service.contract.ToposService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
     *          On ajoute les topos
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
    public List<Topos> getAllToposNotPseudo(String pseudo)
    {
        return toposDao.getAllToposNotPseudo(pseudo);
    }

}
