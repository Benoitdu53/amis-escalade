package com.escalade.controller;

import com.escalade.model.Utilisateur;
import com.escalade.service.contract.ReservationService;
import com.escalade.service.contract.ToposService;
import com.escalade.service.contract.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;

@Controller
public class ProfilController
{

    // ----- Injection des dépendances ----- //

    @Autowired
    private ToposService toposService;

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private UtilisateurService utilisateurService;



    /**
     *          On affiche le profil de l'utilisateur avec ses informations (utilisateur, mail, topos et demande de réservation)
     * @param pseudo
     * @param session
     * @param model
     * @return
     */
    @RequestMapping(value = "profil", method = RequestMethod.GET)
    public String displayMyTopos(@SessionAttribute("pseudo") String pseudo, HttpSession session, Model model){

        // Récupère les topos de l'utilisateur
        model.addAttribute("topos",toposService.getToposByPseudo(pseudo));
        //Récupère les demandes reçus
        model.addAttribute("demandeRecus",reservationService.getDemandeReçus(pseudo));
        //Récupère les demandes expédiés
        model.addAttribute("demandeEnvoye",reservationService.getDemandeExpedie(pseudo));

        return "profil";
    }




    /**
     *          Réservation des topos
     * @param idToposDispo
     * @param pseudo
     * @return
     */
    @RequestMapping(value = "reservationOn/{idToposDispo}", method = RequestMethod.GET)
    public RedirectView reservationOn(@PathVariable("idToposDispo") Long idToposDispo,
                                      @SessionAttribute("pseudo") String pseudo){

        reservationService.reservationOn(idToposDispo, pseudo);

        return new RedirectView("profil");
    }

    @RequestMapping(value = "deleteReservation/{idReservation}/{idTopos}", method = RequestMethod.GET)
    public RedirectView deleteReservation(@PathVariable("idReservation")Long idReservation,
                                          @PathVariable("idTopos")Long idTopos){

        reservationService.deleteReservation(idReservation, idTopos);

        return new RedirectView("profil");
    }

    /**
     *          Change le status de la demande en "En location"
     */
    @RequestMapping(value = "accepterDemande/{idReservation}/{idTopos}",method = RequestMethod.GET)
    public RedirectView accepterDemande(@PathVariable("idReservation") Long idReservation,
                                        @PathVariable("idTopos")Long idTopos){

        reservationService.updateReservation(idReservation, idTopos);

        return new RedirectView("profil");
    }




    /**
     *      Refuse la demande de réservation, remis disponible et suppression de la réservation
     */
    @RequestMapping(value = "refuserDemande/{idReservation}/{idTopos}",method = RequestMethod.GET)
    public RedirectView refuserDemande(@PathVariable("idReservation")Long idReservation,
                                       @PathVariable("idTopos")Long idTopos){

        reservationService.deleteReservation(idReservation, idTopos);

        return new RedirectView("profil");
    }
}
