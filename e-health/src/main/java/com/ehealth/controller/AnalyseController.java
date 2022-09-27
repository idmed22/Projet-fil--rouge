package com.ehealth.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.ehealth.entity.Analyse;
import com.ehealth.repository.AnalyseRepository;

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
public class AnalyseController {
	
	@Autowired
	private AnalyseRepository analyseRepository;
	
	 @GetMapping("/analyse")
	  public List<Analyse> getAllAnalyse() {
	    return analyseRepository.findAll();
	  }
	 
	 @PostMapping("/analyse")
	  public Analyse createAnalyse( @RequestBody Analyse analyse) {
	    return analyseRepository.save(analyse);
	  }
	 
	 @GetMapping("/analyse/{id}")
	  public ResponseEntity<Analyse> getAnalyseById(@PathVariable(value = "id") Long id)
	      throws ResourceNotFoundException {
	    Analyse analyse =
	    		analyseRepository
	            .findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Analyse not found on :: " + id));
	    return ResponseEntity.ok().body(analyse);
	  }
	 
	 
	 @PutMapping("/analyse/{id}")
	  public ResponseEntity<Analyse> updateAnalyse(
	      @PathVariable(value = "id") Long id, @Valid @RequestBody Analyse analyseDetails)
	      throws ResourceNotFoundException {

	    Analyse analyse =
	    		analyseRepository
	            .findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Analyse not found on :: " + id));
	    
	    analyse.setNomPreleveur(analyseDetails.getNomPreleveur());
	    analyse.setAnalyseType(analyseDetails.getAnalyseType());
	    analyse.setAnalyseTypePartie(analyseDetails.getAnalyseTypePartie());
	    analyse.setDatePrelevement(analyseDetails.getDatePrelevement());
	    analyse.setDescription(analyseDetails.getDescription()); // delete this from here
	    analyse.setSangTypes(analyseDetails.getSangTypes());
	    analyse.setPatient(analyseDetails.getPatient());
	  
	 
	    final Analyse updatedAnalyse = analyseRepository.save(analyse);
	    return ResponseEntity.ok(updatedAnalyse);
	  }
	 
	 @DeleteMapping("/analyse/{id}")
	  public Map<String, Boolean> deleteAnalyse(@PathVariable(value = "id") Long id) throws Exception {
	    Analyse analyse =
	    		analyseRepository
	            .findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Analyse not found on :: " + id));

	    analyseRepository.delete(analyse);
	    Map<String, Boolean> response = new HashMap<>();
	    response.put("deleted", Boolean.TRUE);
	    return response;
	  }

}
