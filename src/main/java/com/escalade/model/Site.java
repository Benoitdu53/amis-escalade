package com.escalade.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name= "site")
public class Site implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "departement")
    private String departement;

    @Column(name = "pays")
    private String pays;

    @Column(name="cotation_min")
    private String cotationMin;

    @Column(name="cotation_max")
    private String cotationMax;

    @Column(name = "description")
    private String description;

    @Column(name = "type")
    private String type;

    @OneToMany(mappedBy = "site")
    private List<Secteur> secteurList = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "id_utilisateur")
    private Utilisateur utilisateur;

    @Override
    public String toString()
    {
        return "Site{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", departement='" + departement + '\'' +
                ", pays='" + pays + '\'' +
                ", cotationMin='" + cotationMin + '\'' +
                ", cotationMax='" + cotationMax + '\'' +
                ", description='" + description + '\'' +
                ", type='" + type + '\'' +
                ", secteurList=" + secteurList +
                ", utilisateur=" + utilisateur +
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

    public String getCotationMin()
    {
        return cotationMin;
    }

    public void setCotationMin(final String cotationMin)
    {
        this.cotationMin = cotationMin;
    }

    public String getCotationMax()
    {
        return cotationMax;
    }

    public void setCotationMax(final String cotationMax)
    {
        this.cotationMax = cotationMax;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(final String description)
    {
        this.description = description;
    }

    public String getType()
    {
        return type;
    }

    public void setType(final String type)
    {
        this.type = type;
    }

    public List<Secteur> getSecteurList()
    {
        return secteurList;
    }

    public void setSecteurList(final List<Secteur> secteurList)
    {
        this.secteurList = secteurList;
    }
}
