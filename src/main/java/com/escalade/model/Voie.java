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

    @Column
    private String voie;

    @Column
    private int longueur;

    @Column
    private String cotation;

    @Override
    public String toString()
    {
        return "Voie{" +
                "id=" + id +
                ", voie='" + voie + '\'' +
                ", longueur=" + longueur +
                ", cotation='" + cotation + '\'' +
                '}';
    }

    @OneToMany(mappedBy = "voie")
    private List<Longueur> longueurList = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "id_secteur")
    private Secteur secteur;

    public List<Longueur> getLongueurList()
    {
        return longueurList;
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

    public Long getId()
    {
        return id;
    }

    public void setId(final Long id)
    {
        this.id = id;
    }

    public String getVoie()
    {
        return voie;
    }

    public void setVoie(final String voie)
    {
        this.voie = voie;
    }

    public int getLongueur()
    {
        return longueur;
    }

    public void setLongueur(final int longueur)
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
}
