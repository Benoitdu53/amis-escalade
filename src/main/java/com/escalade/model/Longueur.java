package com.escalade.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "longueur")
public class Longueur implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(name = "long_relais")
    private int longRelais;

    @Column(name = "long_total")
    private int longTotal;

    @ManyToOne
    @JoinColumn(name = "id_voie")
    private Voie voie;

    @Override
    public String toString()
    {
        return "Longueur{" +
                "id=" + id +
                ", longRelais=" + longRelais +
                ", longTotal=" + longTotal +
                ", voie=" + voie +
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

    public int getLongRelais()
    {
        return longRelais;
    }

    public void setLongRelais(final int longRelais)
    {
        this.longRelais = longRelais;
    }

    public int getLongTotal()
    {
        return longTotal;
    }

    public void setLongTotal(final int longTotal)
    {
        this.longTotal = longTotal;
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
