package com.escalade.controller;

import com.escalade.model.Longueur;
import com.escalade.service.contract.LongueurService;
import com.escalade.service.contract.VoieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

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
     *              Affiche le formulaire d'ajout des longueurs
     * @param idVoie
     * @return
     */
    @RequestMapping(value = "/voie/{idVoie}/longueur/add", method = RequestMethod.GET)
    public ModelAndView formLongueur( @PathVariable("idVoie") Long idVoie){

        ModelAndView modelAndView = new ModelAndView("addLongueur", "longueur", new Longueur());

        modelAndView.addObject("idVoie", idVoie);

        return modelAndView;
    }




    /**
     *              Affiche la page des longueurs
     * @param model
     * @return
     */
    @RequestMapping(value = "/voie/{idVoie}/longueur", method = RequestMethod.GET)
    public String displayVoie (Model model, @PathVariable("idVoie") Long idVoie){

        model.addAttribute("voie", voieService.getVoieById(idVoie));
        model.addAttribute("longueurs", longueurService.getLongueurByVoieId(idVoie));

        return "/longueur";
    }



    /**
     *              Ajoute une longueur à une voie
     * @param newLongueur
     * @param result
     * @param idVoie
     * @return
     */
    @RequestMapping(value = "/voie/{idVoie}/longueur/add", method= RequestMethod.POST)
    public Object addLongueur (@Valid @ModelAttribute("longueur") Longueur newLongueur, BindingResult result,
                           @PathVariable("idVoie") Long idVoie){

        try{
            if (result.hasErrors()){
                return "addVoie";
            }
        }catch (Exception e){
            // TODO Exception
        }

        longueurService.insertLongueur(newLongueur, idVoie);

        return new RedirectView("/voie/{idVoie}/longueur");
    }




    /**
     *              Supprime une longueur
     * @return
     */
    @RequestMapping(value = "/longueur/{idLongueur}/delete", method = RequestMethod.GET)
    public RedirectView deleteLongueur (@PathVariable("idLongueur") Long idLongueur){
        longueurService.deleteById(idLongueur);

        return new RedirectView("/sites");
    }
}
