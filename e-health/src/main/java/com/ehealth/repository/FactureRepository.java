package com.ehealth.repository;



import com.ehealth.entity.Facture;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FactureRepository extends JpaRepository<Facture, Long>{

	 

}
