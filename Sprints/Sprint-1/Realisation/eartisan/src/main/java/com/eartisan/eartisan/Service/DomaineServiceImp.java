package com.eartisan.eartisan.Service;

import com.eartisan.eartisan.DAO.DomaineRepository;
import com.eartisan.eartisan.entities.Domaine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/eArtisan")
public class DomaineServiceImp implements IDomaineService {
    @Autowired
    private DomaineRepository domaineRepository;
    @Override
    @RequestMapping(value="/Domaines",method = RequestMethod.GET)
    public List<Domaine> getAll() {
        return domaineRepository.findAll();
    }

    @Override
    @RequestMapping(value="/getDomaine/{id}",method = RequestMethod.GET)
    public Domaine getDomaine(@PathVariable("id") Long id) {
        return domaineRepository.findOne(id);
    }

    @Override
    @RequestMapping(value = "/addDomaine",method = RequestMethod.POST)
    public Domaine addDomaine(@RequestBody Domaine domaine) {
        return domaineRepository.save(domaine);
    }

    @Override
    @RequestMapping(value="/updateDomaine",method = RequestMethod.PUT)
    public Domaine updateDomaine(@RequestBody Domaine domaine) {
        return domaineRepository.saveAndFlush(domaine);
    }

    @Override
    @RequestMapping(value="/deleteDomaine",method = RequestMethod.DELETE)
    public void deleteDomaine(@PathVariable("id") Long id) {

    }
}
