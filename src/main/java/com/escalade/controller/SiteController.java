package com.escalade.controller;

import com.escalade.model.Site;
import com.escalade.service.contract.SecteurService;
import com.escalade.service.contract.SiteService;
import com.escalade.service.contract.VoieService;
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

    @Autowired
    private SiteService siteService;

    @Autowired
    private VoieService voieService;

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
     * Méthode qui ajoute un site en base
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
     *
     * @param model
     * @return le nom de la view
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
     *
     * @param model
     * @return tout les sites d'escalade
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
     *
     * @param model
     * @param id
     * @return le site d'escalade sélectionner
     */
    @RequestMapping(value = "/site/{idSite}", method = RequestMethod.GET)
    public String findSite (Model model, @PathVariable("idSite") Long id){

        model.addAttribute("voies", voieService.getVoieByidSite(id));
        model.addAttribute("secteurs", secteurService.getSectorByIdSite(id));
        model.addAttribute("site", siteService.getSiteById(id));

        return "/site";
    }

}
