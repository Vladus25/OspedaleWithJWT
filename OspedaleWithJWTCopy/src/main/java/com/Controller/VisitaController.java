package com.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.Entity.VisitaEntity;
import com.Service.VisitaService;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/visita")
public class VisitaController {

    @Autowired
    private VisitaService serv;

    @GetMapping("/all")
    public List<VisitaEntity> getVisita(){
        return serv.getVisita();
    }

    @PostMapping("/add")
    public VisitaEntity addVisita(VisitaEntity object){
        return serv.addVisita(object);
    }

    @DeleteMapping("/delete")
    public String deleteVisita(@RequestParam int id){
        serv.deleteVisita(id);
        return "Visita eliminato";
    }
}
