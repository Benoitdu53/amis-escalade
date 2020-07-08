package com.escalade.service.contract;

import com.escalade.model.Utilisateur;

import java.util.List;

public interface UtilisateurService
{
    List<Utilisateur> getUtilisateurs();
    void registrationUtilisateur(Utilisateur newUtilisateur);
    void deleteUtilisateur(Long idUtilisateur);
    Utilisateur loginUtilisateur(String pseudo, String password);
}
