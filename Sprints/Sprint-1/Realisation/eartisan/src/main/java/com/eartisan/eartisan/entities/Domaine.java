package com.eartisan.eartisan.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "TAB_Domaine")
public class Domaine {
    @Id @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String name;

    public Domaine() {
    }

    public Domaine(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
