package com.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.Entity.EsameLaboratorioEntity;
import com.Service.EsameLaboratorioService;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/esame_laboratorio")
public class EsameLaboratorioController {

    @Autowired
    private EsameLaboratorioService serv;

    @GetMapping("/all")
    public List<EsameLaboratorioEntity> getEsameLaboratorio(){
        return serv.getEsameLaboratorio();
    }

    @PostMapping("/add")
    public EsameLaboratorioEntity addEsameLaboratorio(EsameLaboratorioEntity object){
        return serv.addEsameLaboratorio(object);
    }

    @DeleteMapping("/delete")
    public String deleteEsameLaboratorio(@RequestParam int id){
        serv.deleteEsameLaboratorio(id);
        return "EsameLaboratorio eliminato";
    }
}
