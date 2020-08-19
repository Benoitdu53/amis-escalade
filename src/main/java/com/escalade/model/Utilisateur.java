package com.escalade.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "utilisateur")
public class Utilisateur implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nom")
    private String nom;

    @Column(name="prenom")
    private String prenom;

    @Column(name = "pseudo")
    private String pseudo;

    @Column(name = "mail")
    private String mail;

    @Column(name = "password")
    private String password;

    @Column(name="isMembreOfficiel")
    private Boolean isMembreOfficiel;

    @OneToMany(mappedBy = "utilisateur")
    private List<Site> siteList = new ArrayList<>();

    @OneToMany(mappedBy = "utilisateur")
    private List<Secteur> secteurList = new ArrayList<>();

    @OneToMany(mappedBy = "utilisateur")
    private List<Voie> voieList = new ArrayList<>();

    @OneToMany(mappedBy = "utilisateur")
    private List<Longueur> longueurList = new ArrayList<>();

    @OneToMany(mappedBy = "utilisateur")
    private List<Reservation> reservationList = new ArrayList<>();

    @OneToMany(mappedBy = "utilisateur", fetch = FetchType.EAGER)
    private List<Topos> topos =new ArrayList<>();

    @Override
    public String toString()
    {
        return "Utilisateur{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", pseudo='" + pseudo + '\'' +
                ", mail='" + mail + '\'' +
                ", password='" + password + '\'' +
                ", isMembreOfficiel=" + isMembreOfficiel +
                ", siteList=" + siteList +
                ", secteurList=" + secteurList +
                ", voieList=" + voieList +
                ", longueurList=" + longueurList +
                ", reservationList=" + reservationList +
                ", topos=" + topos +
                '}';
    }

    public Long getId()
    {
        return id;
    }

    public void setId(final Long id)
    {
        this.id = id;
    }

    public String getNom()
    {
        return nom;
    }

    public void setNom(final String nom)
    {
        this.nom = nom;
    }

    public String getPrenom()
    {
        return prenom;
    }

    public void setPrenom(final String prenom)
    {
        this.prenom = prenom;
    }

    public String getPseudo()
    {
        return pseudo;
    }

    public void setPseudo(final String pseudo)
    {
        this.pseudo = pseudo;
    }

    public String getMail()
    {
        return mail;
    }

    public void setMail(final String mail)
    {
        this.mail = mail;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(final String password)
    {
        this.password = password;
    }

    public boolean getIsMembreOfficiel()
    {
        return isMembreOfficiel;
    }

    public void setIsMembreOfficiel(final Boolean membreOfficiel)
    {
        isMembreOfficiel = membreOfficiel;
    }

    public List<Site> getSiteList()
    {
        return siteList;
    }

    public void setSiteList(final List<Site> siteList)
    {
        this.siteList = siteList;
    }

    public List<Secteur> getSecteurList()
    {
        return secteurList;
    }

    public void setSecteurList(final List<Secteur> secteurList)
    {
        this.secteurList = secteurList;
    }

    public List<Voie> getVoieList()
    {
        return voieList;
    }

    public void setVoieList(final List<Voie> voieList)
    {
        this.voieList = voieList;
    }

    public List<Longueur> getLongueurList()
    {
        return longueurList;
    }

    public void setLongueurList(final List<Longueur> longueurList)
    {
        this.longueurList = longueurList;
    }

    public List<Reservation> getReservationList()
    {
        return reservationList;
    }

    public void setReservationList(final List<Reservation> reservationList)
    {
        this.reservationList = reservationList;
    }

    public List<Topos> getTopos()
    {
        return topos;
    }

    public void setTopos(final List<Topos> topos)
    {
        this.topos = topos;
    }
}
