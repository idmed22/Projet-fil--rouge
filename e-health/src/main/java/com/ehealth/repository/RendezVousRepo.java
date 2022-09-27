package com.ehealth.repository;

import com.ehealth.entity.RendezVous;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RendezVousRepo extends JpaRepository<RendezVous, Long> {

}
