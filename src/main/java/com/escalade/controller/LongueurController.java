package com.escalade.controller;

import com.escalade.model.Longueur;
import com.escalade.model.Utilisateur;
import com.escalade.service.contract.LongueurService;
import com.escalade.service.contract.VoieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class LongueurController {

    // ----- Injection des dépendances ----- //

    @Autowired
    private VoieService voieService;

    private final LongueurService longueurService;
    @Autowired
    public LongueurController(LongueurService longueurService){
        this.longueurService = longueurService;
    }




    /**
     *          Affiche les longueurs
     * @param model
     * @param idVoie
     * @param session
     * @return
     */
    @RequestMapping(value = "voie/{idVoie}/longueur", method = RequestMethod.GET)
    public String displayLongueur(Model model,
                                  @PathVariable("idVoie") Long idVoie,
                                  HttpSession session){

        model.addAttribute("longueurs", longueurService.getLongueursByIdVoie(idVoie));

        return "longueur";
    }




    /**
     *              Affiche le formulaire d'ajout des longueurs
     * @param idVoie
     * @return
     */
    @RequestMapping(value = "voie/{idVoie}/longueur/add", method = RequestMethod.GET)
    public ModelAndView formLongueur( @PathVariable("idVoie") Long idVoie,
                                      HttpSession session){

        ModelAndView modelAndView = new ModelAndView("addLongueur", "longueur", new Longueur());

        modelAndView.addObject("idVoie", idVoie);

        return modelAndView;
    }




    /**
     *              Ajoute une longueur à une voie
     * @param newLongueur
     * @param result
     * @param idVoie
     * @return
     */
    @RequestMapping(value = "voie/{idVoie}/longueur/add", method= RequestMethod.POST)
    public Object addLongueur (@Valid @ModelAttribute("longueur") Longueur newLongueur, BindingResult result,
                               @PathVariable("idVoie") Long idVoie,
                               @SessionAttribute("utilisateur") Utilisateur utilisateur,
                               HttpSession session){

        longueurService.insertLongueur(newLongueur, idVoie, utilisateur);

        return "redirect:/sites";
    }




    /**
     *              Supprime une longueur
     * @return
     */
    @RequestMapping(value = "longueur/{idLongueur}/delete", method = RequestMethod.GET)
    public String deleteLongueur (@PathVariable("idLongueur") Long idLongueur,
                                        HttpSession session){

        longueurService.deleteById(idLongueur);

        return "redirect:/sites";
    }
}
