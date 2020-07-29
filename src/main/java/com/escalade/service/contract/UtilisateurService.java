package com.escalade.service.contract;

import com.escalade.model.Utilisateur;

import java.util.List;

public interface UtilisateurService
{
    List<Utilisateur> getUtilisateurs();
    Utilisateur getUtilisateurByPseudo(String pseudo);
    List<String> getAllMail();
    List<String> getAllPseudo();
    void registrationUtilisateur(Utilisateur newUtilisateur);
    void deleteUtilisateur(Long idUtilisateur);
    Utilisateur loginUtilisateur(String pseudo, String password);
}
