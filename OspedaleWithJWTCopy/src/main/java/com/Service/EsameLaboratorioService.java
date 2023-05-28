package com.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Entity.EsameLaboratorioEntity;
import com.Repository.EsameLaboratorioRepository;

import java.util.List;

@Service
public class EsameLaboratorioService {

    @Autowired
    private EsameLaboratorioRepository repo;

    public List<EsameLaboratorioEntity> getEsameLaboratorio(){
        return repo.findAll();
    }

    public EsameLaboratorioEntity addEsameLaboratorio(EsameLaboratorioEntity obj){
        return repo.save(obj);
    }

    public String deleteEsameLaboratorio(int id){
        repo.deleteById(id);
        return "EsameLaboratorio eliminato";
    }
}
