package com.escalade.controller;

import com.escalade.model.Topos;
import com.escalade.service.contract.ToposService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class ToposController {

    // ----- Injection des dépendances ----- //

    @Autowired
    private ToposService toposService;




    /**
     *          On affiche la page des topos
     * @param session
     * @param model
     * @return
     */
    @RequestMapping(value = "/topos", method = RequestMethod.GET)
    public String displayTopos (@SessionAttribute("pseudo") String pseudo , HttpSession session, Model model){

        model.addAttribute("topos",toposService.getToposByUtilisateur(pseudo));

        return "/topos";
    }




    /**
     *          Affichage du formulaire d'enregistrement de topos
     * @return
     */
    @RequestMapping(value = "formTopos", method = RequestMethod.GET)
    public ModelAndView formTopos (){

        return new ModelAndView("addTopos","topos", new Topos());
    }




    /**
     *
     * @param topos
     * @return
     */
    @RequestMapping(value = "addTopos", method = RequestMethod.POST)
    public Object addTopos(@Valid @ModelAttribute("topos")Topos topos,
                           @SessionAttribute("pseudo") String pseudo){

        toposService.insertToposByUtilisateur(pseudo, topos);

        return "topos";
    }
}
