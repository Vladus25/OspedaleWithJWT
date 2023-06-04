package com.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.Entity.PazienteEntity;
import com.Repository.PazienteRepository;
import com.Response.DeleteResponse;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

@Service
public class PazienteService {

    @Autowired
    private PazienteRepository repo;

    public List<PazienteEntity> getPaziente(){
        return repo.findAll();
    }

    public PazienteEntity addPaziente(PazienteEntity object){
        return repo.save(object);
    }
    
    public PazienteEntity updatePaziente(int id, PazienteEntity paziente){
    	
        PazienteEntity existingPaziente = repo.findById(id).orElse(null);
        
        if(existingPaziente != null){
        	
            existingPaziente.setNome(paziente.getNome());
            existingPaziente.setCognome(paziente.getCognome());
            existingPaziente.setCodFis(paziente.getCodFis());
            existingPaziente.setIdReparto(paziente.getIdReparto());
            existingPaziente.setSesso(paziente.getSesso());
            existingPaziente.setDataN(paziente.getDataN());
            existingPaziente.setLuogoN(paziente.getLuogoN());
            existingPaziente.setDataRicovero(paziente.getDataRicovero());
            
            return repo.save(existingPaziente);
        }
        return null;
    }
    
    public DeleteResponse deletePaziente(int id) {
        repo.deleteById(id);
        return new DeleteResponse("Paziente eliminato");
    }
    
    public List<Map<String, Object>> getDatiPaziente(Long userId) {
        List<Map<String, Object>> risultati = new ArrayList<>();
        List<Map<String, Object>> queryResult = repo.getDatiPaziente(userId);

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
    
    public void uploadPdf(Integer pazienteId, MultipartFile file) throws IOException {
        Optional<PazienteEntity> pazienteOptional = repo.findById(pazienteId);
        if (pazienteOptional.isPresent()) {
          PazienteEntity paziente = pazienteOptional.get();
          paziente.setFile(file.getBytes());
          repo.save(paziente);
        } else {
          throw new IllegalArgumentException("Paziente non trovato");
        }
      }
    
    public byte[] downloadPdf(int pazienteId) {
        Optional<PazienteEntity> pazienteOptional = repo.findById(pazienteId);
        if (pazienteOptional.isPresent()) {
            PazienteEntity paziente = pazienteOptional.get();
            return paziente.getFile();
        }
        throw new NoSuchElementException("Paziente not found with ID: " + pazienteId);
    }

}
