package com.eartisan.eartisan.DAO;

import com.eartisan.eartisan.entities.Personne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PersonneRepository extends JpaRepository<Personne,Long> {

    /*@Query("update Personne p set p.etat ='ok' where p.id=id")
    void updateEtat(@Param("id") Long id);*/
    ///void updateEtat();
}
