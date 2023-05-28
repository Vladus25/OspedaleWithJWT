package com.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Entity.EsameEntity;
import com.Service.EsameService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/esame")
public class EsameController {
	 	@Autowired
	    private EsameService serv;

	    @GetMapping("/all")
	    public List<EsameEntity> getEsame(){
	        return serv.getEsame();
	    }

	    @PostMapping("/add")
	    public EsameEntity addEsame(EsameEntity object){
	        return serv.addEsame(object);
	    }

	    @DeleteMapping("/delete")
	    public String deleteEsame(@RequestParam int id){
	        serv.deleteEsame(id);
	        return "Esame eliminato";
	    }
}
