package com.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.Entity.RepartoEntity;
import com.Service.RepartoService;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/reparto")
public class RepartoController {

    @Autowired
    private RepartoService serv;

    @GetMapping("/all")
    @PreAuthorize("hasRole('OPERATOR')")
    public List<RepartoEntity> getReparto(){
        return serv.getReparto();
    }

    @PostMapping("/add")
    public RepartoEntity addReparto(RepartoEntity object){
        return serv.addReparto(object);
    }

    @DeleteMapping("/delete")
    public String deleteReparto(@RequestParam int id){
    	serv.deleteReparto(id);
        return "Reparto eliminato";
    }
    
    @PostMapping("/{repartoId}/assign-medico/{medicoId}")
    @PreAuthorize("hasRole('OPERATOR')")
    public RepartoEntity assignMedicoToReparto(@PathVariable("repartoId") Integer repartoId, @PathVariable("medicoId") Integer medicoId) {
        return serv.assignMedicoToReparto(repartoId, medicoId);
    }
}