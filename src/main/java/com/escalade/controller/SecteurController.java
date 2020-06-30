package com.escalade.controller;

import com.escalade.model.Secteur;
import com.escalade.service.contract.SecteurService;
import com.escalade.service.contract.SiteService;
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
public class SecteurController {

    // ----- Injection des dépendances ----- //

    @Autowired
    private VoieService voieService;

    @Autowired
    private SiteService siteService;

    private final SecteurService secteurService;
    @Autowired
    public SecteurController(SecteurService secteurService){
        this.secteurService = secteurService;
    }




    /**
     *              Affiche le formulaire d'ajout de secteur
     * @param idSite
     * @return
     */
    @RequestMapping(value = "/site/{idSite}/secteur/add", method = RequestMethod.GET)
    public ModelAndView formSecteur(@PathVariable("idSite") Long idSite){

        ModelAndView modelAndView = new ModelAndView("addSecteur", "secteur", new Secteur());
        modelAndView.addObject("idSite",idSite);

        return modelAndView;
    }




    /**
     *              Ajoute un secteur à un site
     * @param newSecteur
     * @param result
     * @param idSite
     * @return
     */
    @RequestMapping(value = "/site/{idSite}/secteur/add", method = RequestMethod.POST)
    public Object addSecteur (@Valid @ModelAttribute("secteur") Secteur newSecteur, BindingResult result,
                           @PathVariable("idSite") Long idSite){

        try{
            if (result.hasErrors()){
                return "addSecteur";
            }
        }catch (Exception e){
            // TODO Exception
        }

        secteurService.insertSecteur(newSecteur, idSite);

        return new RedirectView("/site/{idSite}");
    }




    /**
     *              Affiche les secteurs d'un site
     * @param model
     * @param id
     * @return
     */
    @RequestMapping(value = "/site/{idSite}", method = RequestMethod.GET)
    public String displaySecteur (Model model, @PathVariable("idSite") Long id){

        model.addAttribute("secteurs", secteurService.getSectorByIdSite(id));
        model.addAttribute("site", siteService.getSiteById(id));

        return "/secteur";
    }




    /**
     *              Supprime un secteur
     * @return
     */
    @RequestMapping(value = "/secteur/{idSecteur}/delete", method = RequestMethod.GET)
    public RedirectView deleteLongueur (@PathVariable("idSecteur") Long idSecteur){
        secteurService.deleteSecteurById(idSecteur);

        return new RedirectView("/sites");
    }
}
