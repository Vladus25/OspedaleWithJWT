package com.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.Entity.PazienteEntity;
import com.Response.DeleteResponse;
import com.Service.PazienteService;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/paziente")
public class PazienteController {
    
    @Autowired
    private PazienteService serv;

    @GetMapping("/all")
    @PreAuthorize("hasRole('OPERATOR')")
    public List<PazienteEntity> getPaziente(){
        return serv.getPaziente();
    }

    @PostMapping("/add")
    @PreAuthorize("hasRole('OPERATOR')")
    public PazienteEntity addPaziente(@RequestBody PazienteEntity object){
        return serv.addPaziente(object);
    }
    
    @PutMapping("/update/{id}")
    @PreAuthorize("hasRole('OPERATOR')")
    public PazienteEntity updatePaziente(@PathVariable int id, @RequestBody PazienteEntity paziente){
        return serv.updatePaziente(id, paziente);
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('OPERATOR')")
    public DeleteResponse deletePaziente(@PathVariable int id){
        serv.deletePaziente(id);
        return new DeleteResponse("Paziente eliminato");
    }
    
    @GetMapping("/dati/{id}")
    @PreAuthorize("hasRole('PATIENT')")
    public List<Map<String, Object>> getDatiPaziente(@PathVariable("id") Long userId) {
        return serv.getDatiPaziente(userId);
    }
    
    @PostMapping("/upload-pdf/{id}")
    @PreAuthorize("hasRole('OPERATOR')")
    public ResponseEntity<String> uploadPdf(@PathVariable("id") Integer pazienteId, @RequestParam("file") MultipartFile file) {
      try {
        serv.uploadPdf(pazienteId, file);
        return ResponseEntity.ok("File PDF caricato con successo");
      } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Errore durante il caricamento del file PDF");
      }
    }
    
    @GetMapping("/download-pdf/{id}")
    @PreAuthorize("hasRole('PATIENT')")
    public ResponseEntity<byte[]> downloadPdf(@PathVariable("id") int pazienteId) {
        byte[] pdfBytes = serv.downloadPdf(pazienteId);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment", "pdf_filename.pdf");
        return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
    }
    
}