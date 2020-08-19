package com.escalade.service.impl;

import com.escalade.dao.UtilisateurDao;
import com.escalade.model.Utilisateur;
import com.escalade.service.contract.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {

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
     *          Retourne l'utilisateur connecté via son pseudo
     * @param pseudo
     * @return
     */
    @Override
    public Utilisateur getUtilisateurByPseudo(String pseudo) {
        return utilisateurDao.getUtilisateurByPseudo(pseudo);
    }




    /**
     *          Retourne tout les pseudo
     * @return
     */
    @Override
    public List<String> getAllPseudo()
    {
        return utilisateurDao.getAllPseudo();
    }




    /**
     *          Retourne tout les mails des utilisateurs en base
     * @return
     */
    @Override
    public List<String> getAllMail()
    {
        return utilisateurDao.getAllMail();
    }




    /**
     *          Inscription d'un nouvel utilisateur
     * @param newUtilisateur
     */
    @Override
    public void registrationUtilisateur( Utilisateur newUtilisateur)
    {
        String pass = BCrypt.hashpw(newUtilisateur.getPassword(),BCrypt.gensalt());
        newUtilisateur.setPassword(pass);
        utilisateurDao.save(newUtilisateur);
        utilisateurDao.updateUtilisateurIsNotMembre(newUtilisateur);
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
     *
     * @param utilisateur@return
     */
    @Override
    public Utilisateur loginUtilisateur(Utilisateur utilisateur)
    {

        Utilisateur utilisateurRegistred = utilisateurDao.getUtilisateurByPseudo(utilisateur.getPseudo());

        if (utilisateurRegistred != null)
        {
            String password = utilisateur.getPassword();
            String pass = utilisateurRegistred.getPassword();
            if (!BCrypt.checkpw(password,pass)) {
                utilisateur =null;
            } else
            {
                utilisateur = utilisateurRegistred;
            }
        } else{
            utilisateur = null;
        }


            return utilisateur;
        }
    }