package com.escalade.controller;

import com.escalade.model.Secteur;
import com.escalade.service.contract.SecteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    private final SecteurService secteurService;
    @Autowired
    public SecteurController(SecteurService secteurService){
        this.secteurService = secteurService;
    }

    @RequestMapping(value = "/site/{idSite}/secteur/add", method = RequestMethod.GET)
    public ModelAndView formSecteur(@PathVariable("idSite") Long idSite){

        ModelAndView modelAndView = new ModelAndView("addSecteur", "secteur", new Secteur());
        modelAndView.addObject("idSite",idSite);

        return modelAndView;
    }


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
}
