package com.escalade.controller;

import com.escalade.model.Site;
import com.escalade.service.contract.SecteurService;
import com.escalade.service.contract.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

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

    @RequestMapping(value = "formSite", method = RequestMethod.GET)
    public ModelAndView formSite(){

        return new ModelAndView("addSite", "site", new Site());
    }




    /**
     *              Ajoute un site
     * @param newSite
     * @param result
     * @return
     */
    @RequestMapping(value = "/addSite", method = RequestMethod.POST)
    public Object addSite (@Valid @ModelAttribute("site")Site newSite, BindingResult result){

        try{
            if (result.hasErrors()){
                return "addSite";
            }
        }catch (Exception e){
            // TODO Exception
        }

        siteService.insertSite(newSite);
        return new RedirectView("/sites");
    }




    /**
     *              Permet la recherche de site par critère ( Pays, Cotation minimum, Type ) et l'affiche
     * @param model
     * @param pays
     * @param cotationMin
     * @param type
     * @return
     */
    @RequestMapping(value = "/searchSites", method = RequestMethod.GET)
    public String findSites( Model model,
                             @RequestParam(name = "pays", defaultValue = "", required = false) String pays,
                             @RequestParam(name = "cotationMin",defaultValue = "0", required = false) int cotationMin,
                             @RequestParam(name = "type", defaultValue = "", required = false) String type) {

        model.addAttribute("sites",siteService.getSearchSites(pays, cotationMin, type));
        model.addAttribute("pays", siteService.getPays());
        model.addAttribute("cotationMin", siteService.getCotationMin());
        model.addAttribute("type", siteService.getType());

        return "/sites";
    }




    /**
     *              Affiche tout les sites
     * @param model
     * @return
     */
    @RequestMapping(value = "/sites", method = RequestMethod.GET)
    public String findAllSites(Model model){

        model.addAttribute("pays", siteService.getPays());
        model.addAttribute("cotationMin", siteService.getCotationMin());
        model.addAttribute("type", siteService.getType());

        model.addAttribute("sites", siteService.getSites());
        return "/sites";
    }




    /**
     *              Supprimer une voie
     */
    @RequestMapping(value = "/site/{idSite}/delete", method = RequestMethod.GET)
    public String deleteLongueur (@PathVariable("idSite") Long idSite){
        siteService.deleteSiteById(idSite);

        return "/site";
    }
}
