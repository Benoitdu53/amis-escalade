package com.escalade.service.contract;

import com.escalade.model.Commentaire;

import java.util.List;

public interface CommentaireService {
    List<Commentaire> getCommentaireBySite(Long id);
    void addCommentaire(String pseudo, Commentaire commentaire, Long idSite);
}
