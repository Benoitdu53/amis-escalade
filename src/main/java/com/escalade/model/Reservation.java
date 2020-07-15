package com.escalade.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "reservation")
public class Reservation implements Serializable
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String status;

    @Column
    private String dateReservation;

    @ManyToOne
    @JoinColumn(name = "id_utilisateur")
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "id_topos")
    private Topos topos;

    @Override
    public String toString()
    {
        return "Reservation{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", dateReservation='" + dateReservation + '\'' +
                ", utilisateur=" + utilisateur +
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

    public String getStatus()
    {
        return status;
    }

    public void setStatus(final String status)
    {
        this.status = status;
    }

    public String getDateReservation()
    {
        return dateReservation;
    }

    public void setDateReservation(final String dateReservation)
    {
        this.dateReservation = dateReservation;
    }

    public Utilisateur getUtilisateur()
    {
        return utilisateur;
    }

    public void setUtilisateur(final Utilisateur utilisateur)
    {
        this.utilisateur = utilisateur;
    }
}
