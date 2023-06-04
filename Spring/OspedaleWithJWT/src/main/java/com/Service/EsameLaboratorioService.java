package com.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Entity.EsameLaboratorioEntity;
import com.Repository.EsameLaboratorioRepository;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class EsameLaboratorioService {

    @Autowired
    private EsameLaboratorioRepository repo;
    
    public List<Map<String, Object>> findEsamiDelPaziente(Integer userId) {
        List<Map<String, Object>> risultati = new ArrayList<>();
        List<Map<String, Object>> queryResult = repo.findEsamiDelPaziente(userId);

        for (Map<String, Object> row : queryResult) {
            Map<String, Object> risultato = new LinkedHashMap<>();
            for (Map.Entry<String, Object> entry : row.entrySet()) {
                String chiave = entry.getKey();
                Object valore = entry.getValue();
                risultato.put(chiave, valore);
            }
            risultati.add(risultato);
        }

        return risultati;
    }

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
