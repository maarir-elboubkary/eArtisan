package com.eartisan.eartisan.Service;

import com.eartisan.eartisan.entities.Domaine;

import java.util.List;

public interface IDomaineService {
    List<Domaine> getAll();
    Domaine getDomaine(Long id);
    Domaine addDomaine(Domaine domaine);
    Domaine updateDomaine(Domaine domaine);
    void deleteDomaine(Long id);
}
