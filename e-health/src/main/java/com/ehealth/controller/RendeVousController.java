package com.ehealth.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.ehealth.entity.RendezVous;
import com.ehealth.repository.RendezVousRepo;

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
public class RendeVousController {
	
	
				 @Autowired
				 private RendezVousRepo rendVoRepository;
				 
				 @GetMapping("/RendezVous")
				  public List<RendezVous> getAllRendezVous() {
				    return rendVoRepository.findAll();
				  }
                  
				 @PostMapping("/RendezVous")
						  public RendezVous createRendezVous( @RequestBody RendezVous rendezVous) {
						    return rendVoRepository.save(rendezVous);
						  }
				 
				 @GetMapping("/RendezVous/{id}")
				  public ResponseEntity<RendezVous> getRendeyVousById(@PathVariable(value = "id") Long id)
				      throws ResourceNotFoundException {
					 RendezVous rendezVous =
							 rendVoRepository
				            .findById(id)
				            .orElseThrow(() -> new ResourceNotFoundException("Rendez Vous not found on :: " + id));
				    return ResponseEntity.ok().body(rendezVous);
				  }
				 
				 
				 @PutMapping("/RendezVous/{id}")
				  public ResponseEntity<RendezVous> updatePatient(
				      @PathVariable(value = "id") Long id, @Valid @RequestBody RendezVous RendezVousDetails)
				      throws ResourceNotFoundException {

					 RendezVous rendezVous =
							 rendVoRepository
				            .findById(id)
				            .orElseThrow(() -> new ResourceNotFoundException("Rendez Vous not found on :: " + id));
				    
					 rendezVous.setRendezVousDate(RendezVousDetails.getRendezVousDate());
					 rendezVous.setValider(RendezVousDetails.isValider());
				    
				    final RendezVous updatedRendezVous = rendVoRepository.save(rendezVous);
				    return ResponseEntity.ok(updatedRendezVous);
				  }
				 
				 
				 @DeleteMapping("/RendezVous/{id}")
				  public Map<String, Boolean> deletePatient(@PathVariable(value = "id") Long id) throws Exception {
					 RendezVous rendezVous =
							 rendVoRepository
				            .findById(id)
				            .orElseThrow(() -> new ResourceNotFoundException("Rendez Vous not found on :: " + id));

					 rendVoRepository.delete(rendezVous);
				    Map<String, Boolean> response = new HashMap<>();
				    response.put("deleted", Boolean.TRUE);
				    return response;
				  }
				 
}
