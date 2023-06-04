package com.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Entity.VisitaEntity;
import com.Repository.VisitaRepository;

import java.util.List;

@Service
public class VisitaService {

    @Autowired
    private VisitaRepository repo;

    public List<VisitaEntity> getVisita(){
        return repo.findAll();
    }

    public VisitaEntity addVisita(VisitaEntity obj){
        return repo.save(obj);
    }

    public String deleteVisita(int id){
        repo.deleteById(id);
        return "Visita eliminato";
    }
}
