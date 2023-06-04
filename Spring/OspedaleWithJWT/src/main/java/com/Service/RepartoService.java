package com.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Entity.MedicoEntity;
import com.Entity.RepartoEntity;
import com.Repository.MedicoRepository;
import com.Repository.RepartoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RepartoService {

    @Autowired
    private RepartoRepository repo;
    
    @Autowired
    private MedicoRepository repoM;

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
    
    public RepartoEntity assignMedicoToReparto(Integer repartoId, Integer medicoId) {
        Optional<RepartoEntity> repartoOptional = repo.findById(repartoId);
        Optional<MedicoEntity> medicoOptional = repoM.findById(medicoId);

        if (repartoOptional.isPresent() && medicoOptional.isPresent()) {
            RepartoEntity reparto = repartoOptional.get();
            MedicoEntity medico = medicoOptional.get();

            reparto.setIdMedico(medico);
            return repo.save(reparto);
        }

        return null;
    }
}
