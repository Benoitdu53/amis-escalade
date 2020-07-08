package com.escalade.dao;

import com.escalade.model.Utilisateur;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurDao extends CrudRepository<Utilisateur, Long>
{
    @Query("SELECT u FROM Utilisateur u WHERE u.pseudo = :pseudo")
    Utilisateur getUtilisateurByPseudo(@Param("pseudo") String pseudo);

}
