package com.escalade.service.impl;

import com.escalade.model.Site;
import com.escalade.model.Utilisateur;
import com.escalade.service.contract.ValidationService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ValidationServiceImpl implements ValidationService {
    Map<String,String> erreurMessages = new HashMap<>();

    public Map<String,String> validationUtilisateurRegistration(Utilisateur utilisateur){
        erreurMessages.clear();

        if (!utilisateur.getPassword().equals(utilisateur.getConfirmationPassword())){
            erreurMessages.put("confirmationMdp","Les mots de passes ne sont pas identiques");
        }

    return erreurMessages;

    }

    public Map<String,String> validationAddSite(Site site){

        String cotationMin = site.getCotationMin();
        String cotationMax = site.getCotationMax();

        return erreurMessages;
    }
}
