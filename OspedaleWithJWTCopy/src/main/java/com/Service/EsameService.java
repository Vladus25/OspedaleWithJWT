package com.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Entity.EsameEntity;
import com.Repository.EsameRepository;

@Service
public class EsameService {
	
	@Autowired
    private EsameRepository repo;

    public List<EsameEntity> getEsame(){
        return repo.findAll();
    }

    public EsameEntity addEsame(EsameEntity obj){
        return repo.save(obj);
    }

    public String deleteEsame(int id){
        repo.deleteById(id);
        return "Esame eliminato";
    }
}
