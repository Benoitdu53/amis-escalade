package com.escalade.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name= "site")
public class Site implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;
    @Column
    private String nom;
    @Column
    private String departement;
    @Column
    private String pays;
    @Column(name = "nbre_secteur")
    private int nbreSecteur;
    @Column
    private String type;
    @Column(name="cotation_min")
    private int cotationMin;
    @Column(name="cotation_max")
    private int cotationMax;
    @Column(name="longueur_max")
    private int longueurMax;

    @Override
    public String toString()
    {
        return "Site{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", departement='" + departement + '\'' +
                ", pays='" + pays + '\'' +
                ", nbreSecteur=" + nbreSecteur +
                ", type='" + type + '\'' +
                ", cotationMin=" + cotationMin +
                ", cotationMax=" + cotationMax +
                ", longueurMax=" + longueurMax +
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

    public String getDepartement()
    {
        return departement;
    }

    public void setDepartement(final String departement)
    {
        this.departement = departement;
    }

    public String getPays()
    {
        return pays;
    }

    public void setPays(final String pays)
    {
        this.pays = pays;
    }

    public int getNbreSecteur()
    {
        return nbreSecteur;
    }

    public void setNbreSecteur(final int nbreSecteur)
    {
        this.nbreSecteur = nbreSecteur;
    }

    public String getType()
    {
        return type;
    }

    public void setType(final String type)
    {
        this.type = type;
    }

    public int getCotationMin()
    {
        return cotationMin;
    }

    public void setCotationMin(final int cotationMin)
    {
        this.cotationMin = cotationMin;
    }

    public int getCotationMax()
    {
        return cotationMax;
    }

    public void setCotationMax(final int cotationMax)
    {
        this.cotationMax = cotationMax;
    }

    public int getLongueurMax()
    {
        return longueurMax;
    }

    public void setLongueurMax(final int longueurMax)
    {
        this.longueurMax = longueurMax;
    }
}
