package com.ehealth.repository;

import com.ehealth.entity.DossierMedical;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository 
public interface DossierMedicalRepo extends JpaRepository<DossierMedical, Long>{

}
