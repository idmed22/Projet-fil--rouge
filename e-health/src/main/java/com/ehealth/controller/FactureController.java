package com.ehealth.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.ehealth.entity.Facture;
import com.ehealth.repository.FactureRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/api")
public class FactureController {
	
	
		  @Autowired
		  private FactureRepository factureRepository;
	

		  @GetMapping("/facture")
		  public List<Facture> getAllFacture() {
		    return factureRepository.findAll();
		  }
		  
		  @PostMapping("/facture")
		  public Facture createFacture( @RequestBody Facture facture) {
		    return factureRepository.save(facture);
		  }
		  
		  @GetMapping("/facture/{id}")
		  public ResponseEntity<Facture> getFactureById(@PathVariable(value = "id") Long id)
		      throws ResourceNotFoundException {
		    Facture facture =
		    		factureRepository
		            .findById(id)
		            .orElseThrow(() -> new ResourceNotFoundException("Facture not found on :: " + id));
		    return ResponseEntity.ok().body(facture);
		  }
		  
		  
		  @PutMapping("/facture/{id}")
		  public ResponseEntity<Facture> updateFacture(
		      @PathVariable(value = "id") Long id, @Valid @RequestBody Facture factureDetails)
		      throws ResourceNotFoundException {

		    Facture facture =
		    		factureRepository
		            .findById(id)
		            .orElseThrow(() -> new ResourceNotFoundException("Facture not found on :: " + id));
		    
		    facture.setFactureDate(factureDetails.getFactureDate());
		    facture.setMontant(factureDetails.getMontant());
		    facture.setPayer(factureDetails.isPayer());
		    facture.setPatients(factureDetails.getPatients());
		  
		    final Facture updatedFacture = factureRepository.save(facture);
		    return ResponseEntity.ok(updatedFacture);
		  }
		  
		  
		  @DeleteMapping("/facture/{id}")
		  public Map<String, Boolean> deleteFacture(@PathVariable(value = "id") Long id) throws Exception {
		    Facture facture =
		    		factureRepository
		            .findById(id)
		            .orElseThrow(() -> new ResourceNotFoundException("Facture not found on :: " + id));

		    factureRepository.delete(facture);
		    Map<String, Boolean> response = new HashMap<>();
		    response.put("deleted", Boolean.TRUE);
		    return response;
		  }
	
}
