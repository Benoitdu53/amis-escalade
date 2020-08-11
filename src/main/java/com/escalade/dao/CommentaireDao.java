package com.escalade.dao;

import com.escalade.model.Commentaire;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentaireDao extends CrudRepository<Commentaire,Long> {

    @Query("SELECT c FROM Commentaire c WHERE c.site.id = :id")
    List<Commentaire> getCommentaireBySite(@Param("id")Long id);

    @Query("SELECT c FROM Commentaire c WHERE c.id = :idCommentaire")
    Commentaire getCommentaireById(@Param("idCommentaire") Long id);
}
