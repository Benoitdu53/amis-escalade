package com.escalade.service.impl;

import com.escalade.model.Utilisateur;
import com.escalade.service.contract.ValidationService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ValidationServiceImpl implements ValidationService {

    public Map<String,String> validationUtilisateurRegistration(Utilisateur utilisateur){
        Map<String,String> erreurMessages = new HashMap<>();

        if (!utilisateur.getPassword().equals(utilisateur.getConfirmationPassword())){
            erreurMessages.put("confirmationMdp","Les mots de passes ne sont pas identiques");
        }

    return erreurMessages;

    }
}
