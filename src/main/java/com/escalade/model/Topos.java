package com.escalade.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "topos")
public class Topos implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String nom;

    @Column
    private String description;

    @Column
    private String lieu;

    @OneToMany(mappedBy = "topos")
    private List<Reservation> reservationList = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "id_utilisateur")
    private Utilisateur utilisateur;

    @Override
    public String toString()
    {
        return "Topos{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                ", lieu='" + lieu + '\'' +
                ", reservation=" + reservation +
                ", date='" + date + '\'' +
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

    public String getLieu()
    {
        return lieu;
    }

    public void setLieu(final String lieu)
    {
        this.lieu = lieu;
    }

    public Boolean getReservation()
    {
        return reservation;
    }

    public void setReservation(final Boolean reservation)
    {
        this.reservation = reservation;
    }

    public String getDate()
    {
        return date;
    }

    public void setDate(final String date)
    {
        this.date = date;
    }

    @Column
    private Boolean reservation;

    @Column
    private String date;
}
