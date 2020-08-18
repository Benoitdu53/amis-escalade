package com.escalade.service.contract;

import com.escalade.model.Commentaire;
import com.escalade.model.Utilisateur;

import java.util.List;

public interface CommentaireService {
    List<Commentaire> getCommentaireBySiteId(Long idCommentaire);
    Commentaire getCommentaireById(Long idCommentaire);
    void addCommentaire(Utilisateur utilisateur, Commentaire commentaire, Long idSite);
    void updateCommentaire(Utilisateur utilisateur, Commentaire commentaire);
    void deleteCommentaire(Long idSite);
}
