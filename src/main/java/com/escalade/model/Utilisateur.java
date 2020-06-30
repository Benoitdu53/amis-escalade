package com.escalade.model;

import javax.persistence.*;
import java.io.Serializable;

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

    public Boolean getMembreOfficiel()
    {
        return isMembreOfficiel;
    }

    public void setMembreOfficiel(final Boolean membreOfficiel)
    {
        isMembreOfficiel = membreOfficiel;
    }
}
