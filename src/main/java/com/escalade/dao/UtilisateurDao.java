package com.escalade.dao;

import com.escalade.model.Topos;
import com.escalade.model.Utilisateur;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface UtilisateurDao extends CrudRepository<Utilisateur, Long>
{
    @Query("SELECT u FROM Utilisateur u WHERE u.pseudo = :pseudo")
    Utilisateur getUtilisateurByPseudo(@Param("pseudo") String pseudo);

    @Query("SELECT u.pseudo FROM Utilisateur u")
    List<String> getAllPseudo();

    @Query("SELECT u.mail FROM Utilisateur u")
    List<String> getAllMail();

    @Transactional
    @Modifying
    @Query("UPDATE Utilisateur u set u.isMembreOfficiel=false where u = :utilisateur")
    void updateUtilisateurIsNotMembre(@Param("utilisateur") Utilisateur utilisateur);
}
