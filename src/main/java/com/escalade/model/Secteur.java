package com.escalade.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "secteur")
public class Secteur implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column
    private Long id;
    @Column
    private String secteur;
    @Column(name = "nbre_voie")
    private int nbreVoie;

    @Override
    public String toString()
    {
        return "Secteur{" +
                "id=" + id +
                ", secteur='" + secteur + '\'' +
                ", nbreVoie=" + nbreVoie +
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

    public String getSecteur()
    {
        return secteur;
    }

    public void setSecteur(final String secteur)
    {
        this.secteur = secteur;
    }

    public int getNbreVoie()
    {
        return nbreVoie;
    }

    public void setNbreVoie(final int nbreVoie)
    {
        this.nbreVoie = nbreVoie;
    }

}
