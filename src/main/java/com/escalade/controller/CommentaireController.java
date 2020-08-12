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

        if(commentaire.getId() == null){
            commentaireService.addCommentaire(pseudo, commentaire, idSite);
        } else {
            commentaireService.updateCommentaire(pseudo, commentaire);
        }

        return new RedirectView("/site/{idSite}");
    }




    /**
     *          Supprimer un commentaire
     * @param idCommentaire
     * @return
     */
    @RequestMapping(value = "/commentaire/delete/{idCommentaire}",method = RequestMethod.GET)
    public RedirectView deleteCommentaire(@PathVariable("idCommentaire") Long idCommentaire){

        commentaireService.deleteCommentaire(idCommentaire);

        return new RedirectView("/site/{idSite}");
    }




    /**
     *          Modifier un commentaire
     * @param idCommentaire
     * @param model
     * @param session
     * @return
     */
    @RequestMapping(value = "/commentaire/modifier/{idCommentaire}", method = RequestMethod.GET)
    public ModelAndView modifierCommentaire(@PathVariable("idCommentaire")Long idCommentaire,
                                            Model model,
                                            HttpSession session){

        Commentaire commentaire = commentaireService.getCommentaireById(idCommentaire);
        model.addAttribute("commentaire",commentaire);

        ModelAndView modelAndView =new ModelAndView ("addCommentaire","commentaire", commentaire);
        Long idSite = commentaire.getSite().getId();
        modelAndView.addObject("idCommentaire",idCommentaire);
        modelAndView.addObject("idSite",idSite);

        return modelAndView;
    }
}
