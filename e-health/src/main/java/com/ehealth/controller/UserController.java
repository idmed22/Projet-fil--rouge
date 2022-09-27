package com.ehealth.controller;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.ehealth.entity.Patient;
import com.ehealth.repository.PatientRepository;
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
public class UserController {
	

//			  @Autowired
//			  private UserRepository userRepository;
			  
			  
			  @Autowired
			  private PatientRepository patientRepository;
			  
			  @GetMapping("/users")
			  public List<Patient> getAllPatients() {
			    return patientRepository.findAll();
			  }
			  
			  @PostMapping("/users")
					  public Patient createPatient( @RequestBody Patient patient) {
					    return patientRepository.save(patient);
					  }
			  
			  
			  @GetMapping("/users/{id}")
			  public ResponseEntity<Patient> getPatientById(@PathVariable(value = "id") Long id)
			      throws ResourceNotFoundException {
			    Patient patient =
			    		patientRepository
			            .findById(id)
			            .orElseThrow(() -> new ResourceNotFoundException("Patient not found on :: " + id));
			    return ResponseEntity.ok().body(patient);
			  }
			  
			  
			  @PutMapping("/users/{id}")
			  public ResponseEntity<Patient> updatePatient(
			      @PathVariable(value = "id") Long id, @Valid @RequestBody Patient patientDetails)
			      throws ResourceNotFoundException {

			    Patient patient =
			    		patientRepository
			            .findById(id)
			            .orElseThrow(() -> new ResourceNotFoundException("Patientt not found on :: " + id));
			    
			    patient.setNom(patientDetails.getNom());
			    patient.setPrenom(patientDetails.getPrenom());
			    patient.setUsername(patientDetails.getUsername());
			    patient.setEmail(patientDetails.getEmail());
			    patient.setAdresse(patientDetails.getAdresse());
			    patient.setPassword(patientDetails.getPassword());
			    patient.setDateNaissance(patientDetails.getDateNaissance());
			    patient.setGender(patientDetails.getGender());
			    patient.setTel(patientDetails.getTel());
			    patient.setVille(patientDetails.getVille());
		       
			    
			   
			    final Patient updatedPatient = patientRepository.save(patient);
			    return ResponseEntity.ok(updatedPatient);
			  }
			  
			  
			 
			  @DeleteMapping("/users/{id}")
			  public Map<String, Boolean> deletePatient(@PathVariable(value = "id") Long id) throws Exception {
			    Patient patient =
			    		patientRepository
			            .findById(id)
			            .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + id));

			    patientRepository.delete(patient);
			    Map<String, Boolean> response = new HashMap<>();
			    response.put("deleted", Boolean.TRUE);
			    return response;
			  }
			  
			 
			
	
}
