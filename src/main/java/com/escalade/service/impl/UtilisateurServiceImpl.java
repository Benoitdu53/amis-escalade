package com.escalade.service.impl;

import com.escalade.dao.UtilisateurDao;
import com.escalade.model.MessageErreur;
import com.escalade.model.Utilisateur;
import com.escalade.service.contract.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UtilisateurServiceImpl implements UtilisateurService
{

    // ----- Injection des dépendances ----- //
    private final UtilisateurDao utilisateurDao;
    @Autowired
    public UtilisateurServiceImpl(UtilisateurDao utilisateurDao){this.utilisateurDao = utilisateurDao;}




    /**
     *          Récupère tout les utilisateurs
     * @return
     */
    @Override
    public List<Utilisateur> getUtilisateurs()
    {
        return StreamSupport.stream(utilisateurDao.findAll().spliterator(),false).collect(Collectors.toList());
    }




    /**
     *          Inscription d'un nouvel utilisateur
     * @param newUtilisateur
     */
    @Override
    public void registrationUtilisateur( Utilisateur newUtilisateur)
    {
        String pass = newUtilisateur.getPassword();
        String confPass = newUtilisateur.getConfirmationPassword();
        String mail = newUtilisateur.getMail();

        // Validité du mot de passe
        try{
            if (!pass.equals(confPass))
            {
                // TODO ajouter un message d'erreur " Les mots de passe ne sont pas identiques"

            }else
            {
                if (pass.length() < 6 || !pass.matches("/d"))
                {
                    // TODO ajouter un message d'erreur " Veuillez saisir un mot de passe d'au moins 6 caractère et qui contient au moins un chiffre"
                }
            }
        }catch (Exception e){
            // TODO Ajouter une exception si besoin
        }

        // Validité du mail
        try{
            if (!mail.matches("@")){
                // TODO Ajouter un message "L'adresse mail n'est pas valide"
            }
        }catch (Exception e){
            // TODO Ajouter une exception si besoin
        }

        // TODO Faire un if, si la map des messages d'erreur est vide lancer le save

        utilisateurDao.save(newUtilisateur);
    }




    /**
     *          Supprime un utilisateur
     * @param idUtilisateur
     */
    @Override
    public void deleteUtilisateur( Long idUtilisateur)
    {
        utilisateurDao.deleteById(idUtilisateur);
    }




    /**
     *          Méthode qui récupère les données login
     * @param pseudo
     * @param password
     * @return
     */
    @Override
    public Utilisateur loginUtilisateur(String pseudo, String password)
    {

        Utilisateur utilisateur = utilisateurDao.getUtilisateurByPseudo(pseudo);

        if (utilisateur != null)
        {
            String pass = utilisateur.getPassword();
            if (!pass.equals(password)) {
                // TODO pseudo ou mot de passe incorrect
                utilisateur =null;
            }
        }
            return utilisateur;
        }
    }