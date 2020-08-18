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

import java.util.Date;
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
     * @param idCommentaire
     * @return
     */
    @Override
    public List<Commentaire> getCommentaireBySiteId(final Long idCommentaire)
    {
        return commentaireDao.getCommentaireBySite(idCommentaire);
    }




    /**
     *          Récupère un commentaire par son id
     * @param idCommentaire
     * @return
     */
    @Override
    public Commentaire getCommentaireById(final Long idCommentaire)
    {
        return commentaireDao.getCommentaireById(idCommentaire);
    }




    /**
     *          Ajout d'un commentaire
     * @param utilisateur
     * @param commentaire
     * @param idSite
     */
    @Override
    public void addCommentaire(final Utilisateur utilisateur, final Commentaire commentaire, Long idSite)
    {
        Site site = siteDao.getSiteById(idSite);
        commentaire.setUtilisateur(utilisateur);
        commentaire.setSite(site);

        commentaireDao.save(commentaire);
    }




    /**
     *          Modifie un commentaire
     * @param utilisateur
     * @param commentaire
     */
    @Override
    public void updateCommentaire(final Utilisateur utilisateur, final Commentaire commentaire)
    {
        Commentaire commentaireUpdate = commentaireDao.getCommentaireById(commentaire.getId());
        commentaireUpdate.setUtilisateur(utilisateur);
        commentaireUpdate.setTitre(commentaire.getTitre());
        commentaireUpdate.setCommentaire(commentaire.getCommentaire());
        commentaireUpdate.setDateCommentaire(new Date());

        commentaireDao.save(commentaireUpdate);
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
