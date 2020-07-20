package com.escalade.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "voie")
public class Voie implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(name="nom")
    private String nom;

    @Column(name = "taille")
    private int taille;


    @OneToMany(mappedBy = "voie")
    private List<Longueur> longueurList = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "id_secteur")
    private Secteur secteur;

    @ManyToOne
    @JoinColumn(name = "id_utilisateur")
    private Utilisateur utilisateur;

    @Override
    public String toString()
    {
        return "Voie{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", taille=" + taille +
                ", longueurList=" + longueurList +
                ", secteur=" + secteur +
                '}';
    }

    public List<Longueur> getLongueurList()
    {
        return longueurList;
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

    public int getTaille()
    {
        return taille;
    }

    public void setTaille(final int taille)
    {
        this.taille = taille;
    }

    public void setLongueurList(final List<Longueur> longueurList)
    {
        this.longueurList = longueurList;
    }

    public Secteur getSecteur()
    {
        return secteur;
    }

    public void setSecteur(final Secteur secteur)
    {
        this.secteur = secteur;
    }
}
