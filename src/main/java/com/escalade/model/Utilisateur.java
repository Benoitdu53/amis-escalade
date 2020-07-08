package com.escalade.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "utilisateur")
public class Utilisateur implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull(message = "Veuillez saisir un nom")
    @Column(name = "nom")
    private String nom;

    @NotNull(message = "Veuillez saisir un prenom")
    @Column(name="prenom")
    private String prenom;

    @NotNull(message = "Veuillez saisir un pseudo")
    @Column(name = "pseudo")
    private String pseudo;

    @NotNull(message = "Veuillez saisir une adresse mail")
    @Column(name = "mail")
    private String mail;

    @NotNull(message = "Veuillez saisir un mot de passe")
    @Size(min = 6, message = "Veuillez saisir un mot de passe supérieur à 5 caractères")
    @Column(name = "password")
    private String password;

    @Transient
    private String confirmationPassword;

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
                ", confirmationPassword='" + confirmationPassword + '\'' +
                ", isMembreOfficiel=" + isMembreOfficiel +
                '}';
    }

    public String getConfirmationPassword()
    {
        return confirmationPassword;
    }

    public void setConfirmationPassword(final String confirmationPassword)
    {
        this.confirmationPassword = confirmationPassword;
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
