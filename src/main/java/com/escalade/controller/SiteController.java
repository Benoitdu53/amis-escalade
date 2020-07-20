package com.escalade.controller;

import com.escalade.model.Site;
import com.escalade.service.contract.SecteurService;
import com.escalade.service.contract.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * @Controller annotation pour les controlleurs classique, généralement utilisé en combinaison avec @RequestMapping
 * @RequestMapping utiliser pour marquer les handlers HTTP ( points d'accès à l'application ) dans la classe controller
 * @Autowired permet l'injection de dépendances entre les beans de l'application
 *              Spring va tout faire -> Création du bean, le chercher, l'injecter automatiquement, ...
 */

@Controller
public class SiteController {

    // ----- Injection des dépendances ----- //

    @Autowired
    private SiteService siteService;

    private final SecteurService secteurService;
    @Autowired
    public SiteController(SecteurService secteurService){
        this.secteurService = secteurService;
    }




    /**
     * Affiche le formulaire d'ajout de site
     * @return
     */
    @RequestMapping(value = "/formSite", method = RequestMethod.GET)
    public ModelAndView formSite(){

        return new ModelAndView("addSite", "site", new Site());
    }




    /**
     *              Ajoute un site
     * @param newSite
     * @return
     */
    @RequestMapping(value = "/addSite", method = RequestMethod.POST)
    public Object addSite (@Valid @ModelAttribute("site")Site newSite,
                           HttpSession session){

        siteService.insertSite(newSite);
        return new RedirectView("/sites");

    }




    /**
     *              Permet la recherche de site par critère ( Pays, Cotation minimum, Type ) et l'affiche
     * @param model
     * @param pays
     * @param departement
     * @param type
     * @return
     */
    @RequestMapping(value = "/searchSites", method = RequestMethod.GET)
    public String findSites( Model model,
                             @RequestParam(name = "pays", defaultValue = "", required = false) String pays,
                             @RequestParam(name = "departement",defaultValue = "", required = false) String departement,
                             @RequestParam(name = "type", defaultValue = "", required = false) String type) {

        model.addAttribute("sites",siteService.getSearchSites(pays, departement, type));
        model.addAttribute("pays", siteService.getPays());
        model.addAttribute("departement", siteService.getDepartement());
        model.addAttribute("type", siteService.getType());

        return "/sites";
    }




    /**
     *              Affiche tout les sites
     * @param model
     * @return
     */
    @RequestMapping(value = "/sites", method = RequestMethod.GET)
    public String findAllSites(Model model, HttpSession session){

        model.addAttribute("pays", siteService.getPays());
        model.addAttribute("departement", siteService.getDepartement());
        model.addAttribute("type", siteService.getType());

        model.addAttribute("sites", siteService.getSites());
        return "/sites";
    }




    /**
     *              Supprime une voie
     * @return
     */
    @RequestMapping(value = "/site/{idSite}/delete", method = RequestMethod.GET)
    public RedirectView deleteLongueur (@PathVariable("idSite") Long idSite,
                                        HttpSession session){

        siteService.deleteSiteById(idSite);

        return new RedirectView("/sites");
    }
}
