package com.escalade.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "commentaire")
public class Commentaire implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(name="titre")
    private String titre;

    @Column(name = "commentaire")
    private String commentaire;

    @Column(name = "date_commentaire")
    private String dateCommentaire;

    @ManyToOne
    @JoinColumn(name = "id_utilisateur")
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "id_site")
    private Site site;

    @Override
    public String toString()
    {
        return "Commentaire{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", commentaire='" + commentaire + '\'' +
                ", dateCommentaire='" + dateCommentaire + '\'' +
                ", utilisateur=" + utilisateur +
                ", site=" + site +
                '}';
    }

    public String getDateCommentaire()
    {
        return dateCommentaire;
    }

    public void setDateCommentaire(final String dateCommentaire)
    {
        this.dateCommentaire = dateCommentaire;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(final Long id)
    {
        this.id = id;
    }

    public String getTitre()
    {
        return titre;
    }

    public void setTitre(final String titre)
    {
        this.titre = titre;
    }

    public String getCommentaire()
    {
        return commentaire;
    }

    public void setCommentaire(final String commentaire)
    {
        this.commentaire = commentaire;
    }

    public Utilisateur getUtilisateur()
    {
        return utilisateur;
    }

    public void setUtilisateur(final Utilisateur utilisateur)
    {
        this.utilisateur = utilisateur;
    }

    public Site getSite()
    {
        return site;
    }

    public void setSite(final Site site)
    {
        this.site = site;
    }
}
