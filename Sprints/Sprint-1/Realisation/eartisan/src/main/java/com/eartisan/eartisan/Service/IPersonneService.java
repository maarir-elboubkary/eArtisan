package com.eartisan.eartisan.Service;

import com.eartisan.eartisan.entities.Personne;

import java.util.List;

public interface IPersonneService {

    List<Personne> getAll();
    Personne getPersonne(Long id);
    Personne addPersonne(Personne personne);
    Personne updatePersonne(Personne personne);
    void deletePersonne(Long id);
}
