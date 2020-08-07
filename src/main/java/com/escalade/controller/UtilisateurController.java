package com.escalade.controller;

import com.escalade.model.Utilisateur;
import com.escalade.service.contract.UtilisateurService;
import com.escalade.service.contract.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Map;

@Controller
public class UtilisateurController
{

    // ----- Injection des dépendances ----- //

    @Autowired
    private UtilisateurService utilisateurService;

    @Autowired
    private ValidationService validationService;




    /**
     *          Affiche le formulaire d'inscription utilisateur
     * @return
     */
    @RequestMapping(value = "/formUtilisateur", method = RequestMethod.GET)
    public ModelAndView formUtilisateur(){
        return new ModelAndView("addUtilisateur", "utilisateur", new Utilisateur());
    }




    /**
     *              Inscrit un utilisateur
     * @param newUtilisateur
     * @return
     */
    @RequestMapping(value = "/registrationUtilisateur", method = RequestMethod.POST)
    public Object addUtilisateur (@Valid @ModelAttribute("utilisateur") Utilisateur newUtilisateur,
                                  ModelMap modelMap){

        Map<String,String> erreurMessage;

        erreurMessage = validationService.validationUtilisateurRegistration(newUtilisateur);

            if (erreurMessage.size() != 0){
                modelMap.addAttribute("erreurMessages", erreurMessage);
                return "addUtilisateur";
            }else {
                utilisateurService.registrationUtilisateur(newUtilisateur);
                return new RedirectView("/sites");
            }
    }




    /**
     *          Affiche le formulaire de login
     * @return
     */
    @RequestMapping(value = "/loginUtilisateur", method = RequestMethod.GET)
    public ModelAndView formLogin(){
        return new ModelAndView ("loginUtilisateur", "utilisateur", new Utilisateur());
    }




    /**
     *          Contrôle la validiter du login
     * @param pseudo
     * @param password
     * @return
     */
    @RequestMapping(value = "/validateLogin", method = RequestMethod.POST)
    public Object validateLogin(HttpSession session,
                                @Param("pseudo") String pseudo,
                                @Param("password") String password){

        Utilisateur utilisateur = utilisateurService.loginUtilisateur(pseudo,password);

        if (utilisateur ==null){

            return "/utilisateurs";
        }

        session.setAttribute("pseudo", pseudo);
        session.setAttribute("isMembre", utilisateur.getMembreOfficiel());

        return new RedirectView("/sites");
    }




    /**
     *          Déconnexion de l'utilisateur
     * @param session
     * @return
     */
    @RequestMapping(value = "/deconnexion", method = RequestMethod.GET)
    public Object deconnexion(HttpSession session){

        session.invalidate();
        return new RedirectView ("/sites");
    }
}
