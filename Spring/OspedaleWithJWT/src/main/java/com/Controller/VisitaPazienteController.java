package com.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Entity.VisitaPazienteEntity;
import com.Service.VisitaPazienteService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/visite_pazienti")
public class VisitaPazienteController {
	
	@Autowired
    private VisitaPazienteService serv;
    
    @GetMapping("/visite/{id}")
    @PreAuthorize("hasRole('PATIENT')")
    public List<Map<String, Object>> findVisiteDelPaziente(@PathVariable("id") Integer pazienteId) {
        return serv.findVisiteDelPaziente(pazienteId);
    }
    
    @GetMapping("/all")
    @PreAuthorize("hasRole('OPERATOR')")
    public List<VisitaPazienteEntity> getVisitePazienti(){
        return serv.getVisitePazienti();
    }
}
