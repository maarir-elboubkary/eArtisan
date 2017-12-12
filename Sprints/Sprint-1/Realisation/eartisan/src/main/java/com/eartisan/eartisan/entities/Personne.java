package com.eartisan.eartisan.entities;

import javax.persistence.*;
import java.io.Serializable;
@Entity(name = "TAB_personne")
@MappedSuperclass
public class Personne implements Serializable{
    @Id @GeneratedValue
    private Long id_personne;
    @Column(unique=true,nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;

    private String etat;

    public Personne() {
    }

    public Personne(String email, String password, String etat) {
        this.email = email;
        this.password = password;
        this.etat = etat;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public Long getId_personne() {
        return id_personne;
    }

    public void setId_personne(Long id_personne) {
        this.id_personne = id_personne;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
