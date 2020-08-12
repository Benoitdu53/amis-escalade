package com.escalade.service.contract;

import com.escalade.model.Commentaire;

import java.util.List;

public interface CommentaireService {
    List<Commentaire> getCommentaireBySiteId(Long idCommentaire);
    Commentaire getCommentaireById(Long idCommentaire);
    void addCommentaire(String pseudo, Commentaire commentaire, Long idSite);
    void updateCommentaire(String pseudo, Commentaire commentaire);
    void deleteCommentaire(Long idSite);
}
