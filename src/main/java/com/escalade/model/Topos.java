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

    @Column(name = "is_reserve")
    private Boolean isReserve;

    @Column
    private String date;

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
                ", isReserve=" + isReserve +
                ", date='" + date + '\'' +
                ", reservationList=" + reservationList +
                ", utilisateur=" + utilisateur +
                '}';
    }

    public Boolean getReserve()
    {
        return isReserve;
    }

    public void setReserve(final Boolean reserve)
    {
        isReserve = reserve;
    }

    public List<Reservation> getReservationList()
    {
        return reservationList;
    }

    public void setReservationList(final List<Reservation> reservationList)
    {
        this.reservationList = reservationList;
    }

    public Utilisateur getUtilisateur()
    {
        return utilisateur;
    }

    public void setUtilisateur(final Utilisateur utilisateur)
    {
        this.utilisateur = utilisateur;
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

    public Boolean getIsReserve()
    {
        return isReserve;
    }

    public void setIsReserve(final Boolean reservation)
    {
        this.isReserve = isReserve;
    }

    public String getDate()
    {
        return date;
    }

    public void setDate(final String date)
    {
        this.date = date;
    }
}
