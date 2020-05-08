package com.escalade.controller;

import com.escalade.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
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
     *
     * @param model
     * @return le nom de la view
     */
    @RequestMapping(value = "/sites")
    public String findSites( Model model, @RequestParam(name = "nom", defaultValue = "") String nomCritere){

                model.addAttribute("sites", siteService.getSites());
                model.addAttribute("sitesCritere",siteService.getSearchSites(nomCritere));

                return "sites";
    }
}
