package com.escalade.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "longueur")
public class Longueur implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(name = "nbre_points")
    private int nbrePoints;

    @Column(name = "taille")
    private int taille;

    @Column(name = "cotation")
    private String cotation;


    @ManyToOne
    @JoinColumn(name = "id_utilisateur")
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "id_voie")
    private Voie voie;

    @Override
    public String toString()
    {
        return "Longueur{" +
                "id=" + id +
                ", nbrePoints=" + nbrePoints +
                ", taille=" + taille +
                ", cotation='" + cotation + '\'' +
                ", voie=" + voie +
                '}';
    }

    public Utilisateur getUtilisateur()
    {
        return utilisateur;
    }

    public void setUtilisateur(final Utilisateur utilisateur)
    {
        this.utilisateur = utilisateur;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(final Long id)
    {
        this.id = id;
    }

    public int getNbrePoints()
    {
        return nbrePoints;
    }

    public void setNbrePoints(final int nbrePoints)
    {
        this.nbrePoints = nbrePoints;
    }

    public int getTaille()
    {
        return taille;
    }

    public void setTaille(final int taille)
    {
        this.taille = taille;
    }

    public String getCotation()
    {
        return cotation;
    }

    public void setCotation(final String cotation)
    {
        this.cotation = cotation;
    }

    public Voie getVoie()
    {
        return voie;
    }

    public void setVoie(final Voie voie)
    {
        this.voie = voie;
    }


}
