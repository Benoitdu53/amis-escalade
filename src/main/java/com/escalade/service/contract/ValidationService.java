package com.escalade.service.contract;

import com.escalade.model.Utilisateur;

import java.util.Map;

public interface ValidationService {

    Map<String,String> validationUtilisateurRegistration(Utilisateur utilisateur, final String confirmationPassword);
}
