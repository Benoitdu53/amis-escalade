package com.escalade.dao;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="siteEsclade")
public class SiteEscalade implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private Long id;
    private String type;
    private String secteur;
    private Integer voie;
    private Integer longueur;
    private String cotation;
    private String orientation;
    private String nom;

    /*
        Constructeurs avec paramètres
     */
    public SiteEscalade(final Long id, final String type, final String secteur, final Integer voie, final Integer longueur, final String cotation, final String orientation, final String nom)
    {
        this.id = id;
        this.type = type;
        this.secteur = secteur;
        this.voie = voie;
        this.longueur = longueur;
        this.cotation = cotation;
        this.orientation = orientation;
        this.nom = nom;
    }

    /*
        Getters et setters
     */
    public Long getId()
    {
        return id;
    }

    public void setId(final Long id)
    {
        this.id = id;
    }

    public String getType()
    {
        return type;
    }

    public void setType(final String type)
    {
        this.type = type;
    }

    public String getSecteur()
    {
        return secteur;
    }

    public void setSecteur(final String secteur)
    {
        this.secteur = secteur;
    }

    public Integer getVoie()
    {
        return voie;
    }

    public void setVoie(final Integer voie)
    {
        this.voie = voie;
    }

    public Integer getLongueur()
    {
        return longueur;
    }

    public void setLongueur(final Integer longueur)
    {
        this.longueur = longueur;
    }

    public String getCotation()
    {
        return cotation;
    }

    public void setCotation(final String cotation)
    {
        this.cotation = cotation;
    }

    public String getOrientation()
    {
        return orientation;
    }

    public void setOrientation(final String orientation)
    {
        this.orientation = orientation;
    }

    public String getNom()
    {
        return nom;
    }

    public void setNom(final String nom)
    {
        this.nom = nom;
    }
}
