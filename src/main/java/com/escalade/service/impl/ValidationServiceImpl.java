package com.escalade.service.impl;

import com.escalade.dao.UtilisateurDao;
import com.escalade.model.Utilisateur;
import com.escalade.service.contract.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ValidationServiceImpl implements ValidationService {

    @Autowired
    private UtilisateurDao utilisateurDao;

    /**
     *          Vérifie la validité de l'inscription
     * @param utilisateur
     * @param confirmationPassword
     * @return
     */
    public Map<String,String> validationUtilisateurRegistration(Utilisateur utilisateur, final String confirmationPassword){
        Map<String,String> erreurMessages = new HashMap<>();
        String mail = utilisateur.getMail();
        String pseudo = utilisateur.getPseudo();
        List<String> allPseudo = utilisateurDao.getAllPseudo();
        List<String> allMail = utilisateurDao.getAllMail();

        if (!utilisateur.getPassword().equals(confirmationPassword)){
            erreurMessages.put("confirmationMdp","Les mots de passes ne sont pas identiques");
        }

        for ( String pseudoTemp : allPseudo){
            if (pseudoTemp.equals(pseudo)){
                erreurMessages.put("pseudoErreur","Ce pseudo est déjà utilisé");
            }
        }

        for (String mailTemp : allMail){
            if (mailTemp.equals(mail)){
                erreurMessages.put("mailErreur","Ce mail est déjà utilisé");
            }
        }

    return erreurMessages;

    }

}
