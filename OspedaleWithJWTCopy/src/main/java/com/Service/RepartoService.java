package com.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Entity.RepartoEntity;
import com.Repository.RepartoRepository;

import java.util.List;

@Service
public class RepartoService {

    @Autowired
    private RepartoRepository repo;

    public List<RepartoEntity> getReparto(){
        return repo.findAll();
    }

    public RepartoEntity addReparto(RepartoEntity obj){
        return repo.save(obj);
    }

    public String deleteReparto(int id){
        repo.deleteById(id);
        return "Reparto eliminato";
    }
}
