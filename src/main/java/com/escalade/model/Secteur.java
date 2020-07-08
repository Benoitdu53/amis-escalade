package com.escalade.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "secteur")
public class Secteur implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "secteur")
    private List<Voie> voieList = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "id_site")
    private Site site;

    @Override
    public String toString()
    {
        return "Secteur{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", description=" + description +
                ", voieList=" + voieList +
                ", site=" + site +
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

    public String getDescription()
    {
        return description;
    }

    public void setDescription(final String description)
    {
        this.description = description;
    }

    public List<Voie> getVoieList()
    {
        return voieList;
    }

    public void setVoieList(final List<Voie> voieList)
    {
        this.voieList = voieList;
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
