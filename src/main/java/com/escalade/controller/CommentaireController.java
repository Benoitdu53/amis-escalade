package com.escalade.controller;

import com.escalade.model.Commentaire;
import com.escalade.service.contract.CommentaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class CommentaireController {

    // ----- Injection des dépendances ----- //

    @Autowired
    private CommentaireService commentaireService;




    /**
     *          Affiche du formulaire d'ajout de commentaire
     * @return
     */
    @RequestMapping(value = "/site/{idSite}/add/commentaire", method = RequestMethod.GET)
    public ModelAndView formCommentaire(@PathVariable("idSite")Long idSite){

        ModelAndView modelAndView =new ModelAndView ("addCommentaire","commentaire",new Commentaire());
        modelAndView.addObject("idSite",idSite);

        return  modelAndView;
    }

    @RequestMapping(value = "/addCommentaire/{idSite}", method = RequestMethod.POST)
    public Object addCommentaire(@Valid @ModelAttribute("commentaire")Commentaire commentaire,
                                 @SessionAttribute("pseudo") String pseudo,
                                 @PathVariable("idSite") Long idSite,
                                 HttpSession session){

        commentaireService.addCommentaire(pseudo, commentaire, idSite);

        return new RedirectView("/site/{idSite}");
    }
}
