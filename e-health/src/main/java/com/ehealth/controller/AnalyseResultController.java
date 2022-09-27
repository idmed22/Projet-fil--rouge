package com.ehealth.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.ehealth.entity.AnalyseResults;
import com.ehealth.repository.AnalyseResultRepo;

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
public class AnalyseResultController {
	
			@Autowired
			private AnalyseResultRepo analyseResultRepo;
			
			
			@GetMapping("/analyseResult")
			  public List<AnalyseResults> getAllAnalyseResults() {
			    return analyseResultRepo.findAll();
			  }
			
			 @PostMapping("/analyseResult")
			  public AnalyseResults createAnalyseResults( @RequestBody AnalyseResults analyseResults) {
			    return analyseResultRepo.save(analyseResults);
			  }
			 
			 @GetMapping("/analyseResult/{id}")
			  public ResponseEntity<AnalyseResults> getAnalyseResultsById(@PathVariable(value = "id") Long id)
			      throws ResourceNotFoundException {
				 AnalyseResults analyseResults =
						 analyseResultRepo
			            .findById(id)
			            .orElseThrow(() -> new ResourceNotFoundException("Analyse Results not found on :: " + id));
			    return ResponseEntity.ok().body(analyseResults);
			  }
			 
			 
			 
			 @PutMapping("/analyseResult/{id}")
			  public ResponseEntity<AnalyseResults> updateAnalyseResults(
			      @PathVariable(value = "id") Long id, @Valid @RequestBody AnalyseResults analyseResultDetails)
			      throws ResourceNotFoundException {

				 AnalyseResults analyseResults =
						 analyseResultRepo
			            .findById(id)
			            .orElseThrow(() -> new ResourceNotFoundException("Analyse Results not found on :: " + id));
			 
			    final AnalyseResults updatedAnalyseResults = analyseResultRepo.save(analyseResults);
			    return ResponseEntity.ok(updatedAnalyseResults);
			  }
			 
			 @DeleteMapping("/analyseResult/{id}")
			  public Map<String, Boolean> deleteAnalyseResults(@PathVariable(value = "id") Long id) throws Exception {
			    AnalyseResults analyseResults =
			    		analyseResultRepo
			            .findById(id)
			            .orElseThrow(() -> new ResourceNotFoundException("Analyse Results not found on :: " + id));

			    analyseResultRepo.delete(analyseResults);
			    Map<String, Boolean> response = new HashMap<>();
			    response.put("deleted", Boolean.TRUE);
			    return response;
			  }

}
