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

    @Column
    private int long_relais;

    @Column
    private int long_total;

    @ManyToOne
    @JoinColumn(name = "id_voie")
    private Voie voie;

    public Long getId()
    {
        return id;
    }

    public void setId(final Long id)
    {
        this.id = id;
    }

    public int getLong_relais()
    {
        return long_relais;
    }

    public void setLong_relais(final int long_relais)
    {
        this.long_relais = long_relais;
    }

    public int getLong_total()
    {
        return long_total;
    }

    public void setLong_total(final int long_total)
    {
        this.long_total = long_total;
    }

    public Voie getVoie()
    {
        return voie;
    }

    public void setVoie(final Voie voie)
    {
        this.voie = voie;
    }

    public Longueur(final Long id, final int long_relais, final int long_total, final Voie voie)
    {
        this.id = id;
        this.long_relais = long_relais;
        this.long_total = long_total;
        this.voie = voie;
    }
}
