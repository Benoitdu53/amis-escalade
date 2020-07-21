package com.escalade.service.impl;

import com.escalade.dao.UtilisateurDao;
import com.escalade.model.Utilisateur;
import com.escalade.service.contract.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Override
    public List<String> getAllPseudo()
    {
        return utilisateurDao.getAllPseudo();
    }

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