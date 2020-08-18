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
        String status = "En attente de reponse";

        Topos topos = toposDao.getToposById(idToposDispo);
        Utilisateur utilisateur = utilisateurDao.getUtilisateurByPseudo(pseudo);

        toposDao.updateToposTrue(topos);

        reservation.setUtilisateur(utilisateur);
        reservation.setTopos(topos);

        reservation.setStatus(status);

        reservationDao.save(reservation);
    }




    /**
     *          Récupérer les demandes de réservation Topos reçus
     *
     * @param pseudo
     * @return
     */
    @Override
    public List<Reservation> getDemandeReçus(String pseudo)
    {
        return reservationDao.getReservationsRecus(pseudo);
    }




    /**
     *          Récupérer les demandes de réservation Topos expédiés
     *
     * @param pseudo
     * @return
     */
    @Override
    public List<Reservation> getDemandeExpedie( String pseudo)
    {
        return reservationDao.getReservationExpedies(pseudo);
    }




    /**
     *          Supprime une réservation et met le status du topos en disponible
     * @param idReservation
     * @param idTopos
     */
    @Override
    public void deleteReservation(Long idReservation, Long idTopos)
    {
        Topos topos = toposDao.getToposById(idTopos);

        toposDao.updateToposFalse(topos);

        reservationDao.deleteById(idReservation);
    }




    /**
     *          Accepter la réservation et change le status de la réservation en "En location"
     * @param idReservation
     */
    @Override
    public void updateReservation(Long idReservation, Long idTopos)
    {
        Topos topos = toposDao.getToposById(idTopos);

        toposDao.updateToposTrue(topos);

        reservationDao.updateReservation(idReservation);
    }

}
