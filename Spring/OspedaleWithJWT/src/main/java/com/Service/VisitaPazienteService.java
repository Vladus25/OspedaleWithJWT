package com.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Entity.VisitaPazienteEntity;
import com.Repository.VisitaPazienteRepository;

@Service
public class VisitaPazienteService {
	
	@Autowired
    private VisitaPazienteRepository repo;
	
	public List<VisitaPazienteEntity> getVisitePazienti(){
        return repo.findAll();
    }
    
    public List<Map<String, Object>> findVisiteDelPaziente(Integer userId) {
        List<Map<String, Object>> risultati = new ArrayList<>();
        List<Map<String, Object>> queryResult = repo.findVisiteDelPaziente(userId);

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
}
