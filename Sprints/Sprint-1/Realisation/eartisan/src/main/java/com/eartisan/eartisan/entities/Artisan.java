package com.eartisan.eartisan.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity(name="TAB_artisan")

public class Artisan extends Personne implements Serializable {
    @Id
    @GeneratedValue
    private Long id_artisan;
    @Column(nullable = false)
    private String nom;
    @Column(nullable = false)
    private String prenom;
    @Column(nullable = false)
    private Date dateNaissance;


    public Artisan() {
    }

    public Artisan(String email, String password, String etat, String nom, String prenom, Date dateNaissance) {
        super(email, password, etat);
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
    }

    public Long getId_artisan() {
        return id_artisan;
    }

    public void setId_artisan(Long id_artisan) {
        this.id_artisan = id_artisan;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }
}
