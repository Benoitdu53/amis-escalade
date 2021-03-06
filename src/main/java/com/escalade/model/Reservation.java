package com.escalade.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

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

    @Column(name = "date_reservation")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateReservation = new Date();

    @ManyToOne
    @JoinColumn(name = "id_utilisateur")
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "id_topos")
    private Topos topos;

    public Topos getTopos() {
        return topos;
    }

    public void setTopos(Topos topos) {
        this.topos = topos;
    }

    @Override
    public String toString()
    {
        return "Reservation{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", dateReservation=" + dateReservation +
                ", utilisateur=" + utilisateur +
                ", topos=" + topos +
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

    public Date getDateReservation()
    {
        return dateReservation;
    }

    public void setDateReservation(final Date dateReservation)
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
