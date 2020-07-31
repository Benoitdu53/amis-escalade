package com.escalade.controller;

import com.escalade.model.Topos;
import com.escalade.service.contract.ReservationService;
import com.escalade.service.contract.SiteService;
import com.escalade.service.contract.ToposService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class ToposController {

    // ----- Injection des dépendances ----- //

    @Autowired
    private ToposService toposService;

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private SiteService siteService;



    /**
     *          On affiche la page des topos
     * @param session
     * @param model
     * @return
     */
    @RequestMapping(value = "/topos", method = RequestMethod.GET)
    public String displayAllTopos (@SessionAttribute("pseudo") String pseudo, HttpSession session, Model model){

        model.addAttribute("toposDispo",toposService.getToposDispos(pseudo));

        return "/topos";
    }




    /**
     *          Affichage du formulaire d'enregistrement de topos
     * @return
     */
    @RequestMapping(value = "/formTopos", method = RequestMethod.GET)
    public ModelAndView formTopos (Model model){

        model.addAttribute("nom",siteService.getNomSite());

        return new ModelAndView("addTopos","topos", new Topos());
    }




    /**
     *          Ajouter un topo
     * @param topos
     * @return
     */
    @RequestMapping(value = "/addTopos", method = RequestMethod.POST)
    public Object addTopos(@Valid @ModelAttribute("topos")Topos topos,
                           @SessionAttribute("pseudo") String pseudo){

        toposService.insertToposByUtilisateur(pseudo, topos);

        return new RedirectView("/topos");
    }




    /**
     *          Réservation des topos
     * @param idToposDispo
     * @param pseudo
     * @return
     */
    @RequestMapping(value = "/reservationOn/{idToposDispo}", method = RequestMethod.GET)
    public RedirectView reservationOn(@PathVariable("idToposDispo") Long idToposDispo,
                                      @SessionAttribute("pseudo") String pseudo){

        reservationService.reservationOn(idToposDispo, pseudo);

        return new RedirectView("/profil");
    }




    /**
     *          Change le status de la demande en accepter
     */
    @RequestMapping(value = "/accepterDemande",method = RequestMethod.GET)
    public RedirectView accepterDemande(){

        // TODO Faire modif Accepter demande

        return new RedirectView("/profil");
    }




    /**
     *      Change le status de la demande en refuser
     */
    @RequestMapping(value = "/refuserDemande",method = RequestMethod.GET)
    public RedirectView refuserDemande(){

        // TODO Faire modif refuser demande

        return new RedirectView("/profil");
    }
}
