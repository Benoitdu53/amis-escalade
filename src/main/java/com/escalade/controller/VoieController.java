package com.escalade.controller;

import com.escalade.model.Voie;
import com.escalade.service.contract.VoieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;

public class VoieController
{
    private final VoieService voieService;
    @Autowired
    public VoieController(VoieService voieService){
        this.voieService = voieService;
    }

    @RequestMapping(value = "/site/{idSite}/secteur/{idSecteur}/voie/add", method= RequestMethod.GET)
    public ModelAndView formVoie(@PathVariable("idSecteur") Long idSecteur){

        ModelAndView modelAndView = new ModelAndView("addVoie", "voie", new Voie());
        modelAndView.addObject("idSecteur", idSecteur);

        return modelAndView;
    }

    @RequestMapping(value = "/site/{idSite}/secteur/{idSecteur}/voie/add", method= RequestMethod.POST)
    public Object addVoie (@Valid @ModelAttribute("voie") Voie newVoie, BindingResult result,
                           @PathVariable("idSecteur") Long idSecteur){

        try{
            if (result.hasErrors()){
                return "addVoie";
            }
        }catch (Exception e){
            // TODO Exception
        }

        voieService.insertVoie(newVoie, idSecteur);

        return new RedirectView("/site/{idSite}");
    }

}
