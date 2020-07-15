package com.escalade.service.impl;

import com.escalade.model.ExceptionMessages;
import com.escalade.model.Utilisateur;

import java.util.Map;

public class Validation {

    public ExceptionMessages validationUtilisateurRegistration(Utilisateur utilisateur){
        ExceptionMessages exceptionMessages = new ExceptionMessages();

        if (!utilisateur.getPassword().equals(utilisateur.getConfirmationPassword())){

        }

    return exceptionMessages;

    }
}
