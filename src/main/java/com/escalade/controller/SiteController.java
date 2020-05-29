package com.escalade.controller;

import com.escalade.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

    /**
     * Méthode qui ajoute un site en base
     * @param model
     * @param nom
     * @param departement
     * @param pays
     * @param nbreSecteur
     * @param type
     * @param cotationMin
     * @param cotationMax
     * @param longueurMax
     * @return
     */
    @RequestMapping(value = "/addSite", method = RequestMethod.POST)
    public String addSite ( Model model,
                            @RequestParam(name = "nom", defaultValue = "", required = false) String nom,
                            @RequestParam(name = "departement", defaultValue = "", required = false) String departement,
                            @RequestParam(name = "pays", defaultValue = "", required = false) String pays,
                            @RequestParam(name = "nbreSecteur", defaultValue = "", required = false) String nbreSecteur,
                            @RequestParam(name = "type", defaultValue = "", required = false) String type,
                            @RequestParam(name = "cotationMin", defaultValue = "0", required = false) int cotationMin,
                            @RequestParam(name = "cotationMax", defaultValue = "0", required = false) int cotationMax,
                            @RequestParam(name = "longueurMax", defaultValue = "", required = false) int longueurMax
                            ){
        
        return "sites";
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

        return "sites";
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

}
