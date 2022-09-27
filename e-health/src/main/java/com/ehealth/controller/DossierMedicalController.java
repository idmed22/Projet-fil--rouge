package com.ehealth.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.ehealth.entity.DossierMedical;
import com.ehealth.repository.DossierMedicalRepo;

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
public class DossierMedicalController {
	
	@Autowired
	private DossierMedicalRepo dossierMedicalRepo;
	
	 @GetMapping("/dossierMedical")
	  public List<DossierMedical> getAllDossierMedical() {
	    return dossierMedicalRepo.findAll();
	  }
	 
	 @PostMapping("/dossierMedical")
	  public DossierMedical createDossierMedical( @RequestBody DossierMedical dossierMedical) {
	    return dossierMedicalRepo.save(dossierMedical);
	  }
	 
	 @GetMapping("/dossierMedical/{id}")
	  public ResponseEntity<DossierMedical> getDossierMedicalById(@PathVariable(value = "id") Long id)
	      throws ResourceNotFoundException {
		 DossierMedical dossierMedical =
				 dossierMedicalRepo
	            .findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Dossier Medical not found on :: " + id));
	    return ResponseEntity.ok().body(dossierMedical);
	  }
	 
	 
	 
	 @PutMapping("/dossierMedical/{id}")
	  public ResponseEntity<DossierMedical> updateDossierMedical(
	      @PathVariable(value = "id") Long id, @Valid @RequestBody DossierMedical dossierMedicalDetails)
	      throws ResourceNotFoundException {

		 DossierMedical dossierMedical =
				 dossierMedicalRepo
	            .findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Dossier Medical not found on :: " + id));
	    final DossierMedical updateDossierMedical = dossierMedicalRepo.save(dossierMedical);
	    return ResponseEntity.ok(updateDossierMedical);
	  }
	 
	 @DeleteMapping("/dossierMedical/{id}")
	  public Map<String, Boolean> deleteDossierMedical(@PathVariable(value = "id") Long id) throws Exception {
		 DossierMedical dossierMedical =
				 dossierMedicalRepo
	            .findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Dossier Medical not found on :: " + id));

		 dossierMedicalRepo.delete(dossierMedical);
	    Map<String, Boolean> response = new HashMap<>();
	    response.put("deleted", Boolean.TRUE);
	    return response;
	  }

}
