package com.escalade.service.impl;

import com.escalade.dao.ReservationDao;
import com.escalade.dao.ToposDao;
import com.escalade.dao.UtilisateurDao;
import com.escalade.model.Reservation;
import com.escalade.model.Topos;
import com.escalade.model.Utilisateur;
import com.escalade.service.contract.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {

    // ----- Injection des dépendances ----- //
    @Autowired
    private ReservationDao reservationDao;

    @Autowired
    private UtilisateurDao utilisateurDao;

    @Autowired
    private ToposDao toposDao;



    /**
     *          Demande de réservation d'un topo
     * @param idToposDispo
     * @param pseudo
     */
    @Override
    public void reservationOn(Long idToposDispo, String pseudo) {
        Reservation reservation= new Reservation();
        String status = "En attente de réponse";

        Utilisateur utilisateur = utilisateurDao.getUtilisateurByPseudo(pseudo);
        Topos topos = toposDao.getToposById(idToposDispo);

        reservation.setStatus(status);
        reservation.setUtilisateur(utilisateur);
        reservation.setTopos(topos);

        reservationDao.save(reservation);
    }

    /**
     *          Récupère les topos des autres utilisateurs qui n'ont aucune demandes
     * @param pseudo
     * @return
     */
    @Override
    public List<Topos> getReservationByPseudoIsNull(String pseudo) {

        return reservationDao.getReservationByPseudoIsNull(pseudo);
    }




    /**
     *          Récupère les topos des en attente de réponse.
     * @param pseudo
     * @return
     */
    @Override
    public List<Topos> getReservationByPseudoAttente(String pseudo) {

        return reservationDao.getReservationByPseudoAttente(pseudo);
    }

    @Override
    public List<Topos> getReservationAttente(String pseudo) {

        return reservationDao.getReservationAttente(pseudo);
    }


}