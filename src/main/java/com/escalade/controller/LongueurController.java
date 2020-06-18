package com.escalade.controller;

import com.escalade.model.Longueur;
import com.escalade.model.Voie;
import com.escalade.service.contract.LongueurService;
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
public class LongueurController {

    // ----- Injection des dépendances ----- //

    private final LongueurService longueurService;
    @Autowired
    public LongueurController(LongueurService longueurService){
        this.longueurService = longueurService;
    }




    /**
     *              Affiche le formulaire d'ajout des longueurs
     * @param idSite
     * @param idSecteur
     * @param idVoie
     * @return
     */
    @RequestMapping(value = "/site/{idSite}/secteur/{idSecteur}/voie/{idVoie}/longueur/add", method = RequestMethod.GET)
    public ModelAndView formLongueur(@PathVariable("idSite") Long idSite,
                                     @PathVariable("idSecteur") Long idSecteur,
                                     @PathVariable("idVoie") Long idVoie){

        ModelAndView modelAndView = new ModelAndView("addLongueur", "longueur", new Longueur());
        modelAndView.addObject("idSite", idSite);
        modelAndView.addObject("idSecteur", idSecteur);
        modelAndView.addObject("idVoie", idVoie);

        return modelAndView;
    }




    /**
     *              Ajoute une longueur à une voie
     * @param newVoie
     * @param result
     * @param idSecteur
     * @param idSite
     * @param idVoie
     * @return
     */
    @RequestMapping(value = "/site/{idSite}/secteur/{idSecteur}/voie/{idVoie}/longueur/add", method= RequestMethod.POST)
    public Object addVoie (@Valid @ModelAttribute("voie") Voie newVoie, BindingResult result,
                           @PathVariable("idSecteur") Long idSecteur,
                           @PathVariable("idSite") Long idSite,
                           @PathVariable("idVoie") Long idVoie){

        try{
            if (result.hasErrors()){
                return "addVoie";
            }
        }catch (Exception e){
            // TODO Exception
        }

        //longueurService.insertLongueur(newVoie, idSecteur, idSite);

        return new RedirectView("/site/{idSite}");
    }
}
