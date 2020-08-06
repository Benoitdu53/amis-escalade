package com.escalade.controller;

import com.escalade.model.Commentaire;
import com.escalade.service.contract.CommentaireService;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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




    /**
     *          Ajoute un commentaire
     * @param commentaire
     * @param pseudo
     * @param idSite
     * @param session
     * @return
     */
    @RequestMapping(value = "/addCommentaire/{idSite}", method = RequestMethod.POST)
    public Object addCommentaire(@Valid @ModelAttribute("commentaire")Commentaire commentaire,
                                 @SessionAttribute("pseudo") String pseudo,
                                 @PathVariable("idSite") Long idSite,
                                 HttpSession session){

        commentaireService.addCommentaire(pseudo, commentaire, idSite);

        return new RedirectView("/site/{idSite}");
    }




    /**
     *          Supprimer un commentaire
     * @param idSite
     * @return
     */
    @RequestMapping(value = "/site/{idSite}/secteur/delete/commentaire",method = RequestMethod.GET)
    public RedirectView deleteCommentaire(@PathVariable("idSite") Long idSite){

        commentaireService.deleteCommentaire(idSite);

        return new RedirectView("/site/{idSite}");
    }

    @RequestMapping(value = "/site/{idSite}/secteur/modifier/commentaire", method = RequestMethod.GET)
    public ModelAndView modifierCommentaire(@PathVariable("idSite")Long idSite,
                                            Model model,
                                            HttpSession session){
        model.addAttribute("commentaire",commentaireService.getCommentaireBySite(idSite));

        ModelAndView modelAndView =new ModelAndView ("addCommentaire","commentaire",new Commentaire());
        modelAndView.addObject("idSite",idSite);

        return modelAndView;
    }
}
