package com.escalade.controller;

import com.escalade.model.Voie;
import com.escalade.service.contract.SecteurService;
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
public class VoieController
{

    // ----- Injection des dépendances ----- //

    @Autowired
    private SecteurService secteurService;

    private final VoieService voieService;
    @Autowired
    public VoieController(VoieService voieService){
        this.voieService = voieService;
    }




    /**
     *              Affiche la page des voies
     * @param model
     * @return
     */
    @RequestMapping(value = "/secteur/{idSecteur}/voie", method = RequestMethod.GET)
    public String displayVoie (Model model, @PathVariable("idSecteur") Long idSecteur){

        model.addAttribute("secteur", secteurService.getSectorById(idSecteur));
        model.addAttribute("voies", voieService.getVoieBySecteurId(idSecteur));

        return "/voie";
    }




    /**
     *              Affiche le formulaire d'ajout des voies
     * @param idSecteur
     * @return
     */
    @RequestMapping(value = "/secteur/{idSecteur}/voie/add", method= RequestMethod.GET)
    public ModelAndView formVoie(@PathVariable("idSecteur") Long idSecteur){

        ModelAndView modelAndView = new ModelAndView("addVoie", "voie", new Voie());
        modelAndView.addObject("idSecteur", idSecteur);

        return modelAndView;
    }




    /**
     *              Permet d'ajouter une voie
     * @param newVoie
     * @param result
     * @param idSecteur
     * @return
     */
    @RequestMapping(value = "/secteur/{idSecteur}/voie/add", method= RequestMethod.POST)
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

        return new RedirectView("/secteur/{idSecteur}/voie");
    }




    /**
     *              Supprimer une voie
     */
    @RequestMapping(value = "/voie/{idVoie}/delete", method = RequestMethod.GET)
    public String deleteLongueur (@PathVariable("idVoie") Long idVoie, Model model){
        voieService.deleteVoieById(idVoie);

        return "/voie";
    }
}
