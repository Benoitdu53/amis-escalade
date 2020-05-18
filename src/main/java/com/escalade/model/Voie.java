package com.escalade.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "voie")
public class Voie implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
