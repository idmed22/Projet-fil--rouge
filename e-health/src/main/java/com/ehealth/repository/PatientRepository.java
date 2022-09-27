package com.ehealth.repository;

import java.util.Optional;

import com.ehealth.entity.Patient;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>{
	
	  Optional<Patient> findByUsername(String username);

	  Boolean existsByUsername(String username);

	  Boolean existsByEmail(String email);
 

}
