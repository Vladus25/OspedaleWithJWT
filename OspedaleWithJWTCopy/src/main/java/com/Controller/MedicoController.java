package com.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.Entity.MedicoEntity;
import com.Service.MedicoService;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/medico")
public class MedicoController {

    @Autowired
    private MedicoService serv;

    @GetMapping("/all")
    public List<MedicoEntity> getMedico(){
        return serv.getMedico();
    }

    @PostMapping("/add")
    public MedicoEntity addMedico(MedicoEntity object){
        return serv.addMedico(object);
    }

    @DeleteMapping("/delete")
    public String deleteMedico(@RequestParam int id){
        serv.deleteMedico(id);
        return "Medico eliminato";
    }
    
    @GetMapping("/find/ricerca1/{id}")
    public Object getRepartoByMedicoId(@PathVariable("id") Integer medicoId) {
        return serv.findRepartoByMedicoId(medicoId);
    }
}