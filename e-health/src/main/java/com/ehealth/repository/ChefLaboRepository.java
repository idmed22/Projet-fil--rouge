package com.ehealth.repository;

import com.ehealth.entity.ChefLaboratoire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChefLaboRepository extends JpaRepository<ChefLaboratoire, Long>{

}
