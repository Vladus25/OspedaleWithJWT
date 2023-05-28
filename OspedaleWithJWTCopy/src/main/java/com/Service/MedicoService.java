package com.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Entity.MedicoEntity;
import com.Repository.MedicoRepository;

import java.util.List;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository repo;

    public List<MedicoEntity> getMedico(){
        return repo.findAll();
    }

    public MedicoEntity addMedico(MedicoEntity obj){
        return repo.save(obj);
    }

    public String deleteMedico(int id){
        repo.deleteById(id);
        return "Medico eliminato";
    }
    
    public  Object  findRepartoByMedicoId(Integer medicoId) {
        return repo.findRepartoByMedicoId(medicoId);
    }
}
