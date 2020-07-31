package com.escalade.controller;

import com.escalade.service.contract.ReservationService;
import com.escalade.service.contract.ToposService;
import com.escalade.service.contract.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;

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
     *          On affiche le profil de l'utilisateur avec ses informations (pseudo, mail, topos et demande de réservation)
     * @param pseudo
     * @param session
     * @param model
     * @return
     */
    @RequestMapping(value = "/profil", method = RequestMethod.GET)
    public String displayMyTopos(@SessionAttribute("pseudo") String pseudo, HttpSession session, Model model){

        // Récupère les topos de l'utilisateur
        model.addAttribute("topos",toposService.getToposByPseudo(pseudo));
        //Récupère les demandes reçus
        model.addAttribute("demandeRecus",reservationService.getDemandeReçus(pseudo));
        //Récupère les demandes expédiés
        model.addAttribute("demandeEnvoye",reservationService.getDemandeExpedie(pseudo));

        return "profil";
    }

}
