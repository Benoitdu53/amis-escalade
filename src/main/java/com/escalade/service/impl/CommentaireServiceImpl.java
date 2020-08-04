package com.escalade.service.impl;

import com.escalade.dao.CommentaireDao;
import com.escalade.dao.SiteDao;
import com.escalade.dao.UtilisateurDao;
import com.escalade.model.Commentaire;
import com.escalade.model.Site;
import com.escalade.model.Utilisateur;
import com.escalade.service.contract.CommentaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentaireServiceImpl implements CommentaireService {

    // ----- Injection des dépendances ----- //

    @Autowired
    private CommentaireDao commentaireDao;

    @Autowired
    private UtilisateurDao utilisateurDao;

    @Autowired
    private SiteDao siteDao;




    /**
     *          Récupére les commentaires du site
     * @param id
     * @return
     */
    @Override
    public List<Commentaire> getCommentaireBySite(final Long id)
    {
        return commentaireDao.getCommentaireBySite(id);
    }




    /**
     *          Ajout d'un commentaire
     * @param pseudo
     * @param commentaire
     * @param idSite
     */
    @Override
    public void addCommentaire(final String pseudo, final Commentaire commentaire, Long idSite)
    {
        Utilisateur utilisateur = utilisateurDao.getUtilisateurByPseudo(pseudo);
        Site site = siteDao.getSiteById(idSite);
        commentaire.setUtilisateur(utilisateur);
        commentaire.setSite(site);

        commentaireDao.save(commentaire);
    }




    /**
     *          Supprime un commentaire
     * @param idSite
     */
    @Override
    public void deleteCommentaire(Long idSite) {

        commentaireDao.deleteById(idSite);
    }
}
